package ru.vdmitriy.homeaccounting.builders;

import org.springframework.stereotype.Component;
import ru.vdmitriy.homeaccounting.api.builders.WalletBuilder;
import ru.vdmitriy.homeaccounting.beans.WalletImpl;

import java.math.BigDecimal;

@Component
public class WalletBuilderImpl implements WalletBuilder {
    @Override
    public Object build(String name, String description, String walletId, String walletTypeId, String currencyCode, BigDecimal startValue) {
        return new WalletImpl(name, description, walletId, walletTypeId, currencyCode, startValue);
    }
}
