package ru.vdmitriy.homeaccounting.api;

public interface Wallet {
    String getName();

    String getDescription();

    String getWalletId();

    String getWalletTypeId();

    String getCurrencyCode();

    void setName(String name);

    void setDescription(String description);

    void setWalletId(String walletId);

    void setWalletTypeId(String walletTypeId);

    void setCurrencyCode(String currencyCode);
}
