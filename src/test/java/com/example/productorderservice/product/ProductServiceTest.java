package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private ProductPort productPort;
    private ProductService productService;

    final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
    final long productId = 1L;

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);

        Mockito.when(productPort.getProduct(productId))
               .thenReturn(product);

    }

    @Test
    void 상품조회() {
        productService.addProduct(ProductSteps.상품등록_생성());

        GetProductResponse response = productService.getProduct(productId);

        assertThat(response).isNotNull();
    }

    @Test
    void 상품수정() {
        final long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);

        productService.updateProduct(productId, request);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }
}
