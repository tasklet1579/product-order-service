package com.example.productorderservice.payment.application.port;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long aLong);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
