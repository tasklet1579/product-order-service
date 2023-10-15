package com.example.productorderservice.payment.domain;

import com.example.productorderservice.order.domain.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private String carNumber;

    public Payment(Order order, String carNumber) {
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.hasText(carNumber, "카드 번호는 필수입니다.");
        this.order = order;
        this.carNumber = carNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }
}
