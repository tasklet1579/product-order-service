package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import org.springframework.util.Assert;

class Payment {
    private Long id;
    private final Order order;
    private final String carNumber;

    Payment(Order order, String carNumber) {
        this.order = order;
        this.carNumber = carNumber;
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.hasText(carNumber, "카드 번호는 필수입니다.");
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }
}
