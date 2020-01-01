package ru.vdmitriy.homeaccounting.api.builders;

import java.math.BigDecimal;

public interface WalletBuilder {
    Object build(String name,
                 String description,
                 String walletId,
                 String walletTypeId,
                 String currencyCode,
                 BigDecimal startValue);
}
