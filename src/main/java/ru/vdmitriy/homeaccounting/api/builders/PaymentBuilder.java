package ru.vdmitriy.homeaccounting.api.builders;

import ru.vdmitriy.homeaccounting.api.beans.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PaymentBuilder {

    PaymentBuilder setName(String name);

    PaymentBuilder setUuid(String uuid);

    PaymentBuilder setCategoryUuid(String categoryUuid);

    PaymentBuilder setWalletUuid(String walletUuid);

    PaymentBuilder setComment(String comment);

    PaymentBuilder setValue(BigDecimal value);

    PaymentBuilder setProceed(boolean proceed);

    PaymentBuilder setProfit(boolean profit);

    PaymentBuilder setDate(LocalDateTime date);

    Payment build();
}