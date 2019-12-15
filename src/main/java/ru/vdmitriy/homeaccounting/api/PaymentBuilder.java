package ru.vdmitriy.homeaccounting.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PaymentBuilder {
    Object build(String name,
                 String uuid,
                 String categoryUuid,
                 String walletUuid,
                 String comment,
                 BigDecimal value,
                 boolean proceed,
                 boolean profit,
                 LocalDateTime date);
}