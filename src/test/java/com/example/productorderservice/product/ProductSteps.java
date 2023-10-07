package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSteps {

    public static ExtractableResponse<Response> 상품등록_요청(AddProductRequest request) {
        return RestAssured.given()
                          .log()
                          .all()
                          .contentType(MediaType.APPLICATION_JSON_VALUE)
                          .body(request)
                          .when()
                          .post("/products")
                          .then()
                          .log()
                          .all()
                          .extract();
    }

    public static AddProductRequest 상품등록_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

    public static ExtractableResponse<Response> 상품조회요청(Long productId) {
        ExtractableResponse<Response> response = RestAssured.given()
                                                            .log()
                                                            .all()
                                                            .when()
                                                            .get("/products/{productId}", productId)
                                                            .then()
                                                            .log()
                                                            .all()
                                                            .extract();
        return response;
    }
}
