package com.example.productorderservice.product;

import com.example.productorderservice.product.domain.DiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {

    @Test
    void applyDiscount() {
        int discountedPrice = DiscountPolicy.NONE.applyDiscount(1000);

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void applyDiscount1000() {
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(2000);

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void overDiscount() {
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(500);

        assertThat(discountedPrice).isEqualTo(0);
    }
}
