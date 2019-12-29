package ru.vdmitriy.homeaccounting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vdmitriy.homeaccounting.api.Payment;
import ru.vdmitriy.homeaccounting.api.PaymentBuilder;
import ru.vdmitriy.homeaccounting.api.PaymentRepository;
import ru.vdmitriy.homeaccounting.beans.PaymentImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class PaymentController {

    private final PaymentBuilder paymentBuilder;
    private final PaymentRepository repository;

    @Autowired
    public PaymentController(PaymentBuilder paymentBuilder,
                             PaymentRepository repository) {
        this.paymentBuilder = paymentBuilder;
        this.repository = repository;
    }

    @RequestMapping("/payment")
    public String payment(){
        PaymentImpl payment = (PaymentImpl) getTestPayment();
        System.out.println(payment.toString());
        repository.save(payment);
        System.out.println(repository.count());
        return payment.toString();
    }

//    @RequestParam String name,
//    @RequestParam String comment,
//    @RequestParam double amount,
//    @RequestParam boolean proceed,
//    @RequestParam boolean profit
    @PostMapping("/payment/add")
    public void createPayment(@RequestBody PaymentImpl payment){
        System.out.println(payment.toString());
        PaymentImpl paymentImpl = (PaymentImpl) paymentBuilder.build(payment.getName(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                payment.getComment(),
                payment.getValue(),
                payment.isProceed(),
                payment.isProfit(),
                LocalDateTime.now());
        repository.save(paymentImpl);
    }

    @RequestMapping("/payment/all")
    public String getAllPayments(){
        Iterable<PaymentImpl> paymentList = repository.findAll();
        StringBuilder sb = new StringBuilder();
        paymentList.forEach(p->sb.append(p.toString()).append("<br>"));
        return sb.toString();
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
