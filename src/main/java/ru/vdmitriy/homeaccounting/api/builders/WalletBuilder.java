package ru.vdmitriy.homeaccounting.api.builders;

public interface WalletBuilder {
    Object build(String name,
                 String description,
                 String walletId,
                 String walletTypeId,
                 String currencyCode);
}
