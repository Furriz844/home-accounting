package ru.vdmitriy.homeaccounting.api;

public interface WalletBuilder {
    Object build(String name,
                 String description,
                 String walletId,
                 String walletTypeId,
                 String currencyCode);
}
