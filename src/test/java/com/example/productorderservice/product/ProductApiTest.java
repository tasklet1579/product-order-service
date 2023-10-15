package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품등록() {
        var request = ProductSteps.상품등록_생성();

        var response = ProductSteps.상품등록_요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        ProductSteps.상품등록_요청(ProductSteps.상품등록_생성());
        Long productId = 1L;

        ExtractableResponse<Response> response = ProductSteps.상품조회_요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void 상품수정() {
        ProductSteps.상품등록_요청(ProductSteps.상품등록_생성());

        ExtractableResponse<Response> response = 상품수정_요청();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRepository.findById(1L)
                                    .get()
                                    .getName()).isEqualTo("상품 수정");
    }

    private static ExtractableResponse<Response> 상품수정_요청() {
        return RestAssured.given()
                          .log()
                          .all()
                          .contentType(MediaType.APPLICATION_JSON_VALUE)
                          .body(ProductSteps.상품수정요청())
                          .when()
                          .patch("/products/{productId}", 1L)
                          .then()
                          .log()
                          .all()
                          .extract();
    }
}
