package ru.vdmitriy.homeaccounting.beans;

import ru.vdmitriy.homeaccounting.api.beans.Wallet;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;


@Entity
public class WalletImpl implements Wallet {

    private String name;

    private String description;

    @Id
    private String walletId;

    private String walletTypeId;

    private String currencyCode;

    BigDecimal startValue, currentValue;

    public WalletImpl() {
    }

    public WalletImpl(String name, String description, String walletId, String walletTypeId, String currencyCode, BigDecimal startValue) {
        this.name = name;
        this.description = description;
        this.walletId = walletId;
        this.walletTypeId = walletTypeId;
        this.currencyCode = currencyCode;
        this.startValue = startValue;
        this.currentValue = startValue;
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
    public BigDecimal getStartValue() {
        return startValue;
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
        this.walletTypeId = walletTypeId;
    }

    @Override
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public void setStartValue(BigDecimal startValue) {
        this.startValue = startValue;
    }

    @Override
    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    @Override
    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;

    }

    @Override
    public String toString() {
        return "WalletImpl{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", walletId='" + walletId + '\'' +
                ", walletTypeId='" + walletTypeId + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
