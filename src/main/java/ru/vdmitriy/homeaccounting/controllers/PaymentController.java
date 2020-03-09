package ru.vdmitriy.homeaccounting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vdmitriy.homeaccounting.api.builders.PaymentBuilder;
import ru.vdmitriy.homeaccounting.api.repo.PaymentRepository;
import ru.vdmitriy.homeaccounting.beans.PaymentImpl;

import java.time.LocalDateTime;
import java.util.Objects;
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
    public PaymentImpl getPayment(@RequestParam String uuid) {
        return repository.getPaymentByUuid(uuid);
    }

    @PostMapping("/payment/add")
    public void createPayment(@RequestBody PaymentImpl payment) {
        PaymentImpl paymentImpl = (PaymentImpl) paymentBuilder.setName(payment.getName()).
                //todo generate uuid in builder
                setUuid(UUID.randomUUID().toString())
                .setCategoryUuid(UUID.randomUUID().toString())
                .setWalletUuid(payment.getWalletUuid())
                .setComment(payment.getComment())
                .setValue(payment.getValue())
                .setProceed(payment.isProceed())
                .setProfit(payment.isProfit())
                .setDate(LocalDateTime.now())
                .build();
        repository.save(paymentImpl);
    }

    @PostMapping("/payment/update")
    public String updatePayment(
            @RequestParam String uuid,
            @RequestBody PaymentImpl payment) {
        PaymentImpl paymentImpl = repository.getPaymentByUuid(uuid);
        if (Objects.isNull(paymentImpl)) {
            return "Object not found";
        }
        paymentImpl.setName(payment.getName());
        paymentImpl.setComment(payment.getComment());
        paymentImpl.setValue(payment.getValue());
        paymentImpl.setProceed(payment.isProceed());
        paymentImpl.setProfit(payment.isProfit());
        repository.save(paymentImpl);
        return "ok";
    }

    @RequestMapping("/payment/delete")
    public String deletePayment(@RequestParam String uuid) {
        PaymentImpl paymentImpl = repository.getPaymentByUuid(uuid);
        if (Objects.isNull(paymentImpl)) {
            return "Object not found";
        }
        repository.delete(paymentImpl);
        return ("ok");
    }

    @RequestMapping("/payment/all")
    public String getAllPayments() {
        Iterable<PaymentImpl> paymentList = repository.findAll();
        StringBuilder sb = new StringBuilder();
        paymentList.forEach(p -> sb.append(p.toString()).append("<br>"));
        return sb.toString();
    }
}
