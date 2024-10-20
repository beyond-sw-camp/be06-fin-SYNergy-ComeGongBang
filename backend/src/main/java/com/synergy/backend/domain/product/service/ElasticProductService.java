package com.synergy.backend.domain.product.service;
import com.synergy.backend.domain.likes.repository.LikesRepository;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ElasticProductService {

    private final RestHighLevelClient client;
    private final LikesRepository likesRepository;

    public List<ProductListRes> search(String keyword, Long memberIdx) throws IOException {
        //---------상품 조회------------//
        SearchRequest searchRequest = new SearchRequest("product-data");

//        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(keyword, "product_name.korean", "product_name.nori"));

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.boolQuery()
//                .should(QueryBuilders.multiMatchQuery(keyword, "product_name.korean", "product_name.nori"))
//                .should(QueryBuilders.multiMatchQuery(keyword, "product_hashtags.korean", "product_hashtags.nori"))
//                .should(QueryBuilders.multiMatchQuery(keyword, "atelier_name.korean", "atelier_name.nori"))
//                .should(QueryBuilders.matchQuery("description.nori", keyword))
//        );
        searchSourceBuilder.query(QueryBuilders.boolQuery()
                .should(QueryBuilders.multiMatchQuery(keyword,
                        "product_name.nori",
                        "product_hashtags.nori",
                        "atelier_name.nori")
                )
        );
//        searchSourceBuilder.query(QueryBuilders.boolQuery()
//                .should(QueryBuilders.matchQuery("product_name.nori", keyword))
//                .should(QueryBuilders.matchQuery("product_hashtags.nori", keyword))
//                .should(QueryBuilders.matchQuery( "atelier_name.nori", keyword))
//                .should(QueryBuilders.matchQuery("description.nori", keyword))
//        );


        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();

        //---------회원이 좋아요한 상품 목록 조회------------//
        List<Long> productIdxList = likesRepository.findProductIdxByMember(memberIdx);

        List<ProductListRes> result = new ArrayList<>();

        for (SearchHit hit : hits) {
            Map<String, Object> sourceMap = hit.getSourceAsMap();

            //로그인한 회원이 좋아요한 상품이면 true
            Long productIdx = ((Number) sourceMap.get("product_idx")).longValue();
            boolean isMemberLike = productIdxList.contains(productIdx);

            result.add(ProductListRes.from(
                    productIdx,
                    (String) sourceMap.get("product_name"),
                    ((Number) sourceMap.get("price")).intValue(),
                    (String) sourceMap.get("thumbnail_url"),
                    (Double) sourceMap.get("average_score"),
                    ((Number) sourceMap.get("on_sale_percent")).intValue(),
                    (String) sourceMap.get("atelier_name"),
                    isMemberLike
            ));

        }


        return result;
    }
}