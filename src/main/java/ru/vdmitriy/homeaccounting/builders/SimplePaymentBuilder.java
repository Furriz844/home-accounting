package ru.vdmitriy.homeaccounting.builders;

import org.springframework.stereotype.Component;
import ru.vdmitriy.homeaccounting.api.beans.Payment;
import ru.vdmitriy.homeaccounting.api.builders.PaymentBuilder;
import ru.vdmitriy.homeaccounting.beans.PaymentImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public final class SimplePaymentBuilder implements PaymentBuilder {

    String uuid;
    String categoryUuid;
    String walletUuid;
    String comment;
    BigDecimal value;
    boolean profit;
    boolean proceed;
    LocalDateTime date;
    private String name;

    @Override
    public PaymentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PaymentBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public PaymentBuilder setCategoryUuid(String categoryUuid) {
        this.categoryUuid = categoryUuid;
        return this;
    }

    @Override
    public PaymentBuilder setWalletUuid(String walletUuid) {
        this.walletUuid = walletUuid;
        return this;
    }

    @Override
    public PaymentBuilder setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public PaymentBuilder setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    @Override
    public PaymentBuilder setProceed(boolean proceed) {
        this.proceed = proceed;
        return this;
    }

    @Override
    public PaymentBuilder setProfit(boolean profit) {
        this.profit = profit;
        return this;
    }

    @Override
    public PaymentBuilder setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    @Override
    public Payment build() {
        return buildPayment();
    }

    private Payment buildPayment() {
        Payment payment = new PaymentImpl();
        payment.setName(this.name);
        payment.setUuid(this.uuid);
        payment.setCategoryUuid(this.categoryUuid);
        payment.setWalletUuid(this.walletUuid);
        payment.setComment(this.comment);
        payment.setValue(this.value);
        payment.setProfit(this.profit);
        payment.setProceed(this.proceed);
        payment.setDate(this.date);
        return payment;
    }
}
