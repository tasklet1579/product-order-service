package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;

interface PaymentPort {
    Order getOrder(Long aLong);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
