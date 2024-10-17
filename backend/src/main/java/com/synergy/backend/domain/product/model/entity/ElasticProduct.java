package com.synergy.backend.domain.product.model.entity;

import com.synergy.backend.global.config.Indices;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setting(settingPath = "/static/elastic/elastic-settings.json")
@Mapping(mappingPath = "/static/elastic/product-mappings.json")
@Document(indexName = Indices.PRODUCTS_INDEX)
public class ElasticProduct {
    @Id
    @Field(name = "product_idx", type = FieldType.Long)
    private Long productIdx;

    @Field(name = "product_name", type = FieldType.Text)
    private String productName;

    @Field(name = "description" ,type=FieldType.Text)
    private String description;

    @Field(name = "thumbnail_url",type=FieldType.Text)
    private String thumbnailUrl;

    @Field(name = "price", type=FieldType.Long)
    private Long price;

    @Field(name = "on_sale_percent", type=FieldType.Long)
    private Long onSalePercent;

    @Field(name ="average_score", type=FieldType.Double)
    private Double averageScore;

    @Field(name = "created_at", type=FieldType.Date, format = DateFormat.basic_date)
    private LocalDateTime createdAt;

    @Field(name = "modified_at", type=FieldType.Date, format = DateFormat.basic_date)
    private LocalDateTime modifiedAt;

    @Field(name = "atelier_idx",type=FieldType.Long)
    private Long atelierIdx;

    @Field(name = "atelier_name",type=FieldType.Text)
    private String AtelierName;

    @Field(name = "product_hashtags",type=FieldType.Text)
    private String productHashtags;
}
