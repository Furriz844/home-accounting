package ru.vdmitriy.homeaccounting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vdmitriy.homeaccounting.api.Payment;
import ru.vdmitriy.homeaccounting.api.PaymentBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class PaymentController {

    private final PaymentBuilder paymentBuilder;

    @Autowired
    public PaymentController(PaymentBuilder paymentBuilder) {
        this.paymentBuilder = paymentBuilder;
    }

    @RequestMapping("/payment")
    public String payment(){
        Payment payment = getTestPayment();
        System.out.println(payment.toString());
        return payment.toString();
    }

    public Payment getTestPayment(){
        Payment payment = (Payment) paymentBuilder.build("Test payment",
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "Test payment for application",
                BigDecimal.valueOf(200),
                true,
                false,
                LocalDateTime.now());
        return payment;
    }
}
