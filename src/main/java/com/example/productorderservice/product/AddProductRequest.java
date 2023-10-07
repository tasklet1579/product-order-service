package com.example.productorderservice.product;

import org.springframework.util.Assert;

public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

    public AddProductRequest {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야함");
        Assert.notNull(discountPolicy, "할인정책 필수");
    }
}
