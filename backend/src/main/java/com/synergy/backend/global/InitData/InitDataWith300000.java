package com.synergy.backend.global.InitData;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;


// 회원 수 30만명 넣기


@Component
@RequiredArgsConstructor
public class InitDataWith300000 {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final OrderRepository ordersRepository;

    private static final int USER_COUNT = 300000;
    private static final int ORDER_COUNT_PER_USER = 3;
    private static final int PRODUCT_COUNT = 100;

//    @PostConstruct
    @Transactional
    public void init() {
        // 1. Create Products
        for (int i = 1; i <= PRODUCT_COUNT; i++) {
            createProduct(i);
        }

        // 2. Create Members and Orders
        for (int i = 1; i <= USER_COUNT; i++) {
            Member member = createMember(i);
            createOrdersForMember(member);
        }
    }

    private Member createMember(int id) {
        String email = "user" + id + "@example.com";
        String password = UUID.randomUUID().toString();
        String nickname = "User" + id;
        String cellPhone = "010-" + String.format("%04d", id % 10000) + "-" + String.format("%04d", id / 10000);
        LocalDateTime joinDate = LocalDateTime.now();
        LocalDate birthday = LocalDate.of(1990 + id % 30, 1 + id % 12, 1 + id % 28);

        Member member = Member.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .cellPhone(cellPhone)
                .joinDate(joinDate)
                .birthday(birthday)
                .build();

        return memberRepository.save(member);
    }

    private void createProduct(int id) {
        Product product = Product.builder()
                .name("Product " + id)
                .price(new Random().nextInt(50000) + 10000)
                .onSalePercent(new Random().nextInt(30))
                .description("This is a description for product " + id)
                .thumbnailUrl("https://example.com/thumbnail" + id + ".jpg")
                .deliveryFee(3000)
                .type("General")
                .expiration("2024-12-31")
                .manufacturing("2024-01-01")
                .averageScore(4.0 + (new Random().nextDouble() * 1.0))
                .build();

        productRepository.save(product);
    }

    private void createOrdersForMember(Member member) {
        for (int i = 0; i < ORDER_COUNT_PER_USER; i++) {
            createOrder(member);
        }
    }

    private void createOrder(Member member) {
        Product product = getRandomProduct();
        int totalPrice = product.getPrice() - (product.getPrice() * product.getOnSalePercent() / 100);

        Orders order = Orders.builder()
                .member(member)
                .product(product)
                .orderNumber(UUID.randomUUID().toString())
                .totalPrice(totalPrice)
                .addressIdx("Address" + new Random().nextInt(1000))
                .deliveryState("배송완료")
                .paymentState("결제완료")
                .build();

        ordersRepository.save(order);
    }

    private Product getRandomProduct() {
        long randomProductId = new Random().nextInt(PRODUCT_COUNT) + 1;
        return productRepository.findById(randomProductId).orElseThrow(() -> new IllegalStateException("Product not found"));
    }
}