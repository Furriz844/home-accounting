package ru.vdmitriy.homeaccounting.api;

public interface Wallet {
    String getName();

    String getDescription();

    String getWalletId();

    String getWalletTypeId();

    String getCurrencyCode();
}
