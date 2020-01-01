package ru.vdmitriy.homeaccounting.api.beans;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface Wallet {
    String getName();

    String getDescription();

    String getWalletId();

    String getWalletTypeId();

    String getCurrencyCode();

    BigDecimal getStartValue();

    void setName(String name);

    void setDescription(String description);

    void setWalletId(String walletId);

    void setWalletTypeId(String walletTypeId);

    void setCurrencyCode(String currencyCode);

    void setStartValue(BigDecimal startValue);

    BigDecimal getCurrentValue();

    void setCurrentValue(BigDecimal currentValue);
}
