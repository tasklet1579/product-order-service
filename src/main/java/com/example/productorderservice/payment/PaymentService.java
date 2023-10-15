package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import org.springframework.stereotype.Component;

@Component
class PaymentService {
    private final PaymentPort paymentPort;

    public PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(PaymentRequest request) {
        Order order = paymentPort.getOrder(request.orderId());

        Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCarNumber());
        paymentPort.save(payment);
    }
}
