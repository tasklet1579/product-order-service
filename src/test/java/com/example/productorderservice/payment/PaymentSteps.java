package com.example.productorderservice.payment;

public class PaymentSteps {
    public static PaymentRequest 주문결제요청_생성() {
        Long orderId = 1L;
        String cardNumber = "1234-1234-1234-1234";
        final PaymentRequest request = new PaymentRequest(orderId, cardNumber);
        return request;
    }
}
