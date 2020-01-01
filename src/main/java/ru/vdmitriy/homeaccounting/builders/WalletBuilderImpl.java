package ru.vdmitriy.homeaccounting.builders;

import ru.vdmitriy.homeaccounting.api.WalletBuilder;
import ru.vdmitriy.homeaccounting.beans.WalletImpl;

public class WalletBuilderImpl implements WalletBuilder {
    @Override
    public Object build(String name, String description, String walletId, String walletTypeId, String currencyCode) {
        return new WalletImpl(name, description, walletId, walletTypeId, currencyCode);
    }
}
