package ru.vdmitriy.homeaccounting.beans;

import ru.vdmitriy.homeaccounting.api.beans.Wallet;

public class WalletImpl implements Wallet {

    private String name;

    private String description;

    private String walletId;

    private String walletTypeId;

    private String currencyCode;

    public WalletImpl() {
    }

    public WalletImpl(String name, String description, String walletId, String walletTypeId, String currencyCode) {
        this.name = name;
        this.description = description;
        this.walletId = walletId;
        this.walletTypeId = walletTypeId;
        this.currencyCode = currencyCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getWalletId() {
        return walletId;
    }

    @Override
    public String getWalletTypeId() {
        return walletTypeId;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void setWalletTypeId(String walletTypeId) {
        this.walletTypeId = walletId;
    }

    @Override
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
