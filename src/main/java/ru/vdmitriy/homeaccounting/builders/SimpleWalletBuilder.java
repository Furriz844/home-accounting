package ru.vdmitriy.homeaccounting.builders;

import org.springframework.stereotype.Component;
import ru.vdmitriy.homeaccounting.api.beans.Wallet;
import ru.vdmitriy.homeaccounting.api.builders.WalletBuilder;
import ru.vdmitriy.homeaccounting.beans.WalletImpl;

import java.math.BigDecimal;

@Component
public class SimpleWalletBuilder implements WalletBuilder {
    String name;
    String description;
    String walletId;
    String walletTypeId;
    String currencyCode;
    BigDecimal startValue;

    @Override
    public WalletBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public WalletBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public WalletBuilder setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    @Override
    public WalletBuilder setWalletTypeId(String walletTypeId) {
        this.walletTypeId = walletTypeId;
        return this;
    }

    @Override
    public WalletBuilder setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    @Override
    public WalletBuilder setStartValue(BigDecimal startValue) {
        this.startValue = startValue;
        return this;
    }

    @Override
    public Wallet build() {
        return buildWallet();
    }

    private Wallet buildWallet() {
        Wallet wallet = new WalletImpl();
        wallet.setName(this.name);
        wallet.setDescription(this.description);
        wallet.setWalletId(this.walletId);
        wallet.setWalletTypeId(this.walletTypeId);
        wallet.setCurrencyCode(this.currencyCode);
        wallet.setCurrentValue(this.startValue);
        return wallet;
    }
}
