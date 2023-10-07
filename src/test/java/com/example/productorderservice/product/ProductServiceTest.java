package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품조회() {
        productService.addProduct(ProductSteps.상품등록_생성());
        final long productId = 1L;

        GetProductResponse response = productService.getProduct(productId);

        assertThat(response).isNotNull();
    }
}
