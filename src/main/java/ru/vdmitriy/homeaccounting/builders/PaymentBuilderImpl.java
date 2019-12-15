package ru.vdmitriy.homeaccounting.builders;

import org.springframework.stereotype.Component;
import ru.vdmitriy.homeaccounting.api.Payment;
import ru.vdmitriy.homeaccounting.api.PaymentBuilder;
import ru.vdmitriy.homeaccounting.beans.PaymentImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public final class PaymentBuilderImpl implements PaymentBuilder {
    @Override
    public Payment build(String name,
                         String uuid,
                         String categoryUuid,
                         String walletUuid,
                         String comment,
                         BigDecimal value,
                         boolean proceed,
                         boolean profit,
                         LocalDateTime date) {
        Payment  payment = new PaymentImpl(name,
                uuid,
                categoryUuid,
                walletUuid,
                comment,
                value,
                proceed,
                profit,
                date);
        return payment;
    }
}
