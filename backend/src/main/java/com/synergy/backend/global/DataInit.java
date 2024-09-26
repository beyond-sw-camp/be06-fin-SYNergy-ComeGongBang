package com.synergy.backend.global;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.repository.AtelierRepository;
import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.repository.GradeRepository;
import com.synergy.backend.domain.hashtag.model.entity.Hashtag;
import com.synergy.backend.domain.hashtag.model.entity.ProductHashtag;
import com.synergy.backend.domain.hashtag.repository.HashTagRepository;
import com.synergy.backend.domain.hashtag.repository.ProductHashTagRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.entity.Present;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.domain.orders.repository.PresentRepository;
import com.synergy.backend.domain.product.model.entity.Category;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.entity.ProductImages;
import com.synergy.backend.domain.product.model.entity.ProductMajorOptions;
import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import com.synergy.backend.domain.product.repository.CategoryRepository;
import com.synergy.backend.domain.product.repository.ProductImagesRepository;
import com.synergy.backend.domain.product.repository.ProductMajorOptionsRepository;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.product.repository.ProductSubOptionsRepository;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInit {
    private final CategoryRepository categoryRepository;
    private final AtelierRepository atelierRepository;
    private final ProductRepository productRepository;
    private final HashTagRepository hashtagRepository;
    private final ProductHashTagRepository productHashTagRepository;
    private final MemberRepository memberRepository;
    private final PresentRepository presentRepository;
    private final OrderRepository orderRepository;
    private final ProductSubOptionsRepository productSubOptionsRepository;
    private final ProductMajorOptionsRepository productMajorOptionsRepository;
    private final ProductImagesRepository productImagesRepository;
    private final GradeRepository gradeRepository;

    private final Random random = new Random();

    @PostConstruct
    public void dataInsert() {

        //====================== 등급 저장 ===========================
        List<Grade> grades = List.of(
                Grade.builder().name("Silver").defaultPercent(5).gradeRange(10).recurPercent(3).upgradePercent(7).recurNum(100).upgradeNum(200).imageUrl("https://example.com/silver.png").conditionMin(0).conditionMax(999).build(),
                Grade.builder().name("Gold").defaultPercent(10).gradeRange(20).recurPercent(5).upgradePercent(10).recurNum(300).upgradeNum(400).imageUrl("https://example.com/gold.png").conditionMin(1000).conditionMax(4999).build(),
                Grade.builder().name("Platinum").defaultPercent(15).gradeRange(30).recurPercent(7).upgradePercent(15).recurNum(500).upgradeNum(600).imageUrl("https://example.com/platinum.png").conditionMin(5000).conditionMax(9999).build(),
                Grade.builder().name("Diamond").defaultPercent(20).gradeRange(40).recurPercent(10).upgradePercent(20).recurNum(700).upgradeNum(800).imageUrl("https://example.com/diamond.png").conditionMin(10000).conditionMax(19999).build(),
                Grade.builder().name("VIP").defaultPercent(25).gradeRange(50).recurPercent(15).upgradePercent(25).recurNum(900).upgradeNum(1000).imageUrl("https://example.com/vip.png").conditionMin(20000).conditionMax(100000).build()
        );

        gradeRepository.saveAll(grades);


        //======================멤버 저장===========================
        for(int i=1;i<=3;i++){
            memberRepository.save(Member.builder()
                    .email("member"+i+"@email.com")
                    .password("$2a$10$QbGEtHpLQwwXv4fmQdzzluIgmpztQ57FVm0LTyiIiGCAxtwsWEn1G") //qwer1234
                    .birthday(LocalDate.now())
                    .joinDate(LocalDateTime.now())
                    .cellPhone("000-0000-0000")
                    .nickname("member"+i)
                    .build());
        }


        //======================카테고리 저장===========================
        // 대분류 리스트
        List<String> topCategories = Arrays.asList(
                "식품", "패션/주얼리", "홈리빙", "케이스/문구", "뷰티", "반려동물", "영유아동", "공예"
        );

        //대분류 저장
//        for (String c : topCategories) {
//            categoryRepository.save(Category.builder().categoryName(c).parentCategory(null).categoryLevel(0L).build());
//        }

        //대분류 저장
        List<Category> savedTopCategories = new ArrayList<>();
        for (String c : topCategories) {
            Category savedTopCategory = categoryRepository.save(
                    Category.builder()
                            .categoryName(c)
                            .parentCategory(null)
                            .categoryLevel(0L)
                            .build()
            );
            savedTopCategories.add(savedTopCategory);
        }

        // 중분류 리스트 (대분류와 연관된 이중 리스트)
        List<List<String>> middleCategories = new ArrayList<>();
        middleCategories.add(Arrays.asList("디저트/음료", "수제먹거리", "농축수산물")); // 식품
        middleCategories.add(Arrays.asList("주얼리", "의류", "패션잡화")); // 패션/주얼리
        middleCategories.add(Arrays.asList("홈인테리어", "주방/생활")); // 홈리빙
        middleCategories.add(Arrays.asList("케이스/액세서리", "문구/취미", "기념일/파티", "일러스트/사진", "차량용품")); // 케이스/문구
        middleCategories.add(Arrays.asList("기초/색조/향수", "헤어/바디/클렌징")); // 뷰티
        middleCategories.add(Arrays.asList("사료/간식", "반려패션", "반려용품")); // 반려동물
        middleCategories.add(Arrays.asList("영유아패션", "영유아용품", "답례품/기념품")); // 영유아동
        middleCategories.add(Arrays.asList("인테리어 공예", "주방 공예", "생활 공예")); // 공예

//        List<Category> savedMiddleCategories = new ArrayList<>();
//        //중분류 저장
//        for (int i = 0; i < middleCategories.size(); i++) {
//            List<String> middleCategoryList = middleCategories.get(i);
//            for (String c : middleCategoryList) {
//                Category parent = Category.builder().idx(Long.valueOf(i + 1)).build();
//                categoryRepository.save(Category.builder().categoryName(c).parentCategory(parent).categoryLevel(1L).build());
//            }
//        }

        List<Category> savedMiddleCategories = new ArrayList<>();
        for (int i = 0; i < middleCategories.size(); i++) {
            Category topCategory = savedTopCategories.get(i); // 해당 대분류 가져오기
            List<String> middleCategoryList = middleCategories.get(i);
            for (String c : middleCategoryList) {
                Category savedMiddleCategory = categoryRepository.save(
                        Category.builder()
                                .categoryName(c)
                                .parentCategory(topCategory)  // 부모 대분류 설정
                                .categoryLevel(1L)
                                .build()
                );
                savedMiddleCategories.add(savedMiddleCategory);
            }
        }

        // 소분류 리스트 (중분류와 연관된 이중 리스트)
        List<List<List<String>>> bottomCategories = Arrays.asList(
                Arrays.asList( //식품
                        Arrays.asList("디저트/베이커리", "떡/전통간식", "초콜릿/사탕", "음료/커피/차", "전통주"),// 디저트/음료
                        Arrays.asList("건강식품", "간편식/요리", "식사대용", "가공식품", "김치", "반찬", "소스/장류"), // 수제먹거리
                        Arrays.asList("과일/채소", "잡곡/견과/꿀", "정육/계란", "수산물", "유제품") // 농축수산물
                ),
                Arrays.asList( //패션
                        Arrays.asList("반지", "귀걸이", "목걸이", "팔찌", "발찌"), // 주얼리
                        Arrays.asList("홈웨어/언더웨어", "티셔츠/니트/셔츠", "바지/스커트", "아우터", "원피스/단체복", "생활한복"), // 의류
                        Arrays.asList("여성신발/수제화", "남성신발/수제화", "모자/시즌잡화", "가방/파우치", "지갑", "헤어/기타액세서리", "키링/네임택", "기타 패션잡화") // 패션잡화
                ),
                Arrays.asList(
                        Arrays.asList("가구", "패브릭", "캔들/디퓨저", "꽃/식물", "홈데코용품", "홈갤러리", "캠핑용품"), // 홈인테리어
                        Arrays.asList("주방용품", "생활/욕실용품") // 주방/생활
                ),
                Arrays.asList(
                        Arrays.asList("폰케이스", "음향기기", "케이스", "노트북케이스", "디지털액세서리"), // 케이스/액세서리
                        Arrays.asList("다이어리/스티커", "노트/필기도구", "데스크용품", "인형/장난감", "취미/레저/종교", "디지털콘텐츠"), // 문구/취미
                        Arrays.asList("용돈", "이벤트", "토퍼", "파티/이벤트용품", "카드/편지지"), // 기념일/파티
                        Arrays.asList("커스텀드로잉", "커스텀사진"), // 일러스트/사진
                        Arrays.asList("차키케이스/키링", "차량 방향제", "차량 커버", "주차번호/차량스티커", "차량 수납용품", "차량용 액자") // 차량용품
                ),
                Arrays.asList(
                        Arrays.asList("스킨케어", "메이크업/네일/소품", "향수"), // 기초/색조/향수
                        Arrays.asList("비누/클렌징", "헤어케어", "바디케어") // 헤어/바디/클렌징
                ),
                Arrays.asList(
                        Arrays.asList("사료", "간식"), // 사료/간식
                        Arrays.asList("의류", "패션액세서리"), // 반려패션
                        Arrays.asList("산책용품", "리빙용품", "장난감") // 반려용품
                ),
                Arrays.asList(
                        Arrays.asList("의류", "액세서리", "패션잡화"), // 영유아패션
                        Arrays.asList("인형/장난감", "침구/소품류", "생활/위생용품"), // 영유아용품
                        Arrays.asList("답례품", "출산선물/보관함") // 답례품/기념품
                ),
                Arrays.asList(
                        Arrays.asList("홈데코", "조명", "꽃/화병"), // 인테리어 공예
                        Arrays.asList("테이블웨어", "쿡웨어"), // 주방 공예
                        Arrays.asList("프레그런스", "생활소품") // 생활 공예
                )
        );
//
//        for (List<List<String>> middle : bottomCategories) {
//            for (int i=0;i<middle.size();i++){
//                List<String> bottom = middle.get(i);
//                for (String c : bottom) {
//                    Category parent = Category.builder().idx(Long.valueOf(i + 1)).build();
//                    categoryRepository.save(Category.builder().categoryName(c).parentCategory(parent).categoryLevel(2L).build());
//                }
//            }
//        }

        // 소분류 저장
        int middleIndex = 0;
        for (int i = 0; i < bottomCategories.size(); i++) {
            List<List<String>> middleList = bottomCategories.get(i);
            for (List<String> bottomList : middleList) {
                Category middleCategory = savedMiddleCategories.get(middleIndex++); // 중분류 가져오기
                for (String c : bottomList) {
                    categoryRepository.save(
                            Category.builder()
                                    .categoryName(c)
                                    .parentCategory(middleCategory)  // 부모 중분류 설정
                                    .categoryLevel(2L)
                                    .build()
                    );
                }
            }
        }

        //======================공방 저장===========================
        atelierRepository.save(Atelier.builder()
                .name("달콤한공방").averageScore(4.4).oneLineDescription("달콤한 디저트를 만드는 공방").address("서울특별시 강남구").addressDetail("테헤란로 123번지").havingFollowerCount(1200).title("달콤한 세상, 디저트").content("마카롱, 쿠키, 케이크 등 다양한 디저트를 제공하는 달콤한공방입니다.").profileImage("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png")
                .build());

        atelierRepository.save(Atelier.builder()
                .name("핸드메이드 향기").averageScore(5.0).oneLineDescription("천연 비누와 향초 공방").address("부산광역시 해운대구").addressDetail("해운대로 456번지").havingFollowerCount(850).title("천연의 향기, 핸드메이드 비누").content("자연에서 얻은 재료로 만드는 핸드메이드 비누와 향초를 소개합니다.").profileImage("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png") // 임의의 URL
                .build());

        atelierRepository.save(Atelier.builder()
                .name("예술가의 집").averageScore(4.8).oneLineDescription("공예와 예술작품을 만날 수 있는 공방").address("대구광역시 중구").addressDetail("중앙로 789번지").havingFollowerCount(530).title("예술을 집에서 즐기세요").content("다양한 공예 작품과 그림을 직접 보고 체험할 수 있는 공방입니다.").profileImage("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png") // 임의의 URL
                .build());

        atelierRepository.save(Atelier.builder()
                .name("목공의 세계").averageScore(4.7).oneLineDescription("나무로 만드는 공방").address("전라남도 순천시").addressDetail("순천로 101번지").havingFollowerCount(950).title("나무의 따뜻함을 전하는 공방").content("원목을 이용해 다양한 가구와 소품을 제작하는 공방입니다.").profileImage("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png") // 임의의 URL
                .build());

        atelierRepository.save(Atelier.builder()
                .name("작은 정원").averageScore(4.6).oneLineDescription("플랜테리어와 가드닝 공방").address("경기도 용인시").addressDetail("수지구 202번지").havingFollowerCount(1500).title("식물로 꾸미는 작은 공간").content("플랜테리어 소품과 가드닝 도구를 판매하며, 직접 심고 가꿀 수 있는 체험을 제공합니다.").profileImage("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png") // 임의의 URL
                .build());


        //======================해시 태그===========================
        List<String> hashtags = Arrays.asList("추석", "핫딜", "best 선물", "살수록 할인", "가을", "두바이 초콜릿", "건강");
        for (String hashtag : hashtags) {
            hashtagRepository.save(Hashtag.builder().name(hashtag).build());
        }


        //======================상품 저장===========================
        for (int i = 1; i <= 15; i++) {
            productRepository.save(
                    Product.builder()
                            .name("상품" + i).price(10000 + i * 1000).thumbnailUrl("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/"+(random.nextInt(8) + 1)+".png").averageScore(Math.round((3.5 + (1.5 * Math.random())) * 10) / 10.0).atelier(Atelier.builder().idx(1L).build()).category(Category.builder().idx(34L).build()).build());
        }

        for (int i = 16; i <= 30; i++) {
            productRepository.save(
                    Product.builder()
                            .name("상품" + i).price(10000 + i * 1000).thumbnailUrl("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/"+(random.nextInt(8) + 1)+".png").averageScore(Math.round((3.5 + (1.5 * Math.random())) * 10) / 10.0).atelier(Atelier.builder().idx(2L).build()).category(Category.builder().idx(35L).build()).build());
        }

        for (int i = 31; i <= 45; i++) {
            productRepository.save(
                    Product.builder()
                            .name("상품" + i).price(10000 + i * 1000).thumbnailUrl("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/"+(random.nextInt(8) + 1)+".png").averageScore(Math.round((3.5 + (1.5 * Math.random())) * 10) / 10.0).atelier(Atelier.builder().idx(3L).build()).category(Category.builder().idx(36L).build()).build());
        }

        for (int i = 46; i <= 75; i++) {
            productRepository.save(
                    Product.builder()
                            .name("상품" + i).price(10000 + i * 1000).thumbnailUrl("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/"+(random.nextInt(8) + 1)+".png").averageScore(Math.round((3.5 + (1.5 * Math.random())) * 10) / 10.0).atelier(Atelier.builder().idx(4L).build()).category(Category.builder().idx(37L).build()).build());
        }

        for (int i = 76; i <= 105; i++) {
            productRepository.save(
                    Product.builder()
                            .name("상품" + i).price(10000 + i * 1000).thumbnailUrl("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/"+(random.nextInt(8) + 1)+".png").averageScore(Math.round((3.5 + (1.5 * Math.random())) * 10) / 10.0).atelier(Atelier.builder().idx(5L).build()).category(Category.builder().idx(38L).build()).build());
        }

        //======================상품 이미지===========================
        for(int i=1;i<=105;i++){
            for(int j=1;j<=8;j++){
                productImagesRepository.save(ProductImages.builder()
                        .product(Product.builder().idx(Long.valueOf(i)).build())
                        .imageUrl("https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/"+j+".png")
                        .build());
            }
        }



        //======================상품 - 해시 태그===========================
        for (int i = 1; i <= 105; i++) {
            productHashTagRepository.save(ProductHashtag.builder().
                    product(Product.builder().idx(Long.valueOf(i)).build())
                    .hashtag(Hashtag.builder().idx(Long.valueOf((i-1)%7+1)).build())
                    .build());
        }


        //======================선물 보내기===========================
        presentRepository.save(Present.builder().message("1 send gift to 2").address("서울시 관악구 봉천로 345-23").addressDetail("4층").fromMember(
                Member.builder().idx(1L).build()).toMember(Member.builder().idx(2L).build()).build());
        presentRepository.save(Present.builder().message("1 send gift to 3").address("서울시 관악구 봉천로 345-23").addressDetail("4층").fromMember(
                Member.builder().idx(1L).build()).toMember(Member.builder().idx(3L).build()).build());
        presentRepository.save(Present.builder().message("2 send gift to 1").address("서울시 관악구 봉천로 345-23").addressDetail("4층").fromMember(
                Member.builder().idx(2L).build()).toMember(Member.builder().idx(1L).build()).build());
        presentRepository.save(Present.builder().message("3 send gift to 1").address("서울시 관악구 봉천로 345-23").addressDetail("4층").fromMember(
                Member.builder().idx(3L).build()).toMember(Member.builder().idx(1L).build()).build());


        //======================주문 (선물 관련)===========================
        orderRepository.save(Orders.builder()
                .product(Product.builder().idx(1L).build())
                .deliveryState("배송 완료")
                .present(Present.builder().idx(1L).build())
                .totalPrice(12000)
                .member(Member.builder().idx(1L).build()).build());
        orderRepository.save(Orders.builder()
                .product(Product.builder().idx(2L).build())
                .deliveryState("배송 완료")
                .present(Present.builder().idx(1L).build())
                .totalPrice(12000)
                .member(Member.builder().idx(1L).build()).build());
        orderRepository.save(Orders.builder()
                .product(Product.builder().idx(3L).build())
                .deliveryState("배송 완료")
                .present(Present.builder().idx(2L).build())
                .totalPrice(12000)
                .member(Member.builder().idx(1L).build()).build());
        orderRepository.save(Orders.builder()
                .product(Product.builder().idx(4L).build())
                .deliveryState("배송 완료")
                .present(Present.builder().idx(3L).build())
                .totalPrice(12000)
                .member(Member.builder().idx(2L).build()).build());
        orderRepository.save(Orders.builder()
                .product(Product.builder().idx(5L).build())
                .deliveryState("배송 완료")
                .present(Present.builder().idx(4L).build())
                .totalPrice(12000)
                .member(Member.builder().idx(3L).build()).build());


        //======================옵션===========================
        for(int i=1;i<=105;i++){
            for(int j=1;j<=3;j++){
                ProductMajorOptions productMajorOptions = productMajorOptionsRepository.save(ProductMajorOptions.builder().name("majorOption"+j).product(
                        Product.builder().idx(Long.valueOf(i)).build()).build());
                for(int k=1;k<=4;k++){
                    productSubOptionsRepository.save(
                            ProductSubOptions.builder().majorOption(productMajorOptions)
                                    .name("subOption"+k).inventory(10).addPrice(1000+100*k)
                                    .build());
                }
            }
        }

    }
}
