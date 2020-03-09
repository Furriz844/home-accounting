package ru.vdmitriy.homeaccounting.api.builders;

import ru.vdmitriy.homeaccounting.api.beans.Wallet;

import java.math.BigDecimal;

public interface WalletBuilder {
    WalletBuilder setName(String name);

    WalletBuilder setDescription(String description);

    WalletBuilder setWalletId(String walletId);

    WalletBuilder setWalletTypeId(String walletTypeId);

    WalletBuilder setCurrencyCode(String currencyCode);

    WalletBuilder setStartValue(BigDecimal startValue);

    Wallet build();

}
