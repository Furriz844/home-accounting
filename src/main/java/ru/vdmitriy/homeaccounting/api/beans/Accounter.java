package ru.vdmitriy.homeaccounting.api.beans;

import java.math.BigDecimal;

public interface Accounter {

    BigDecimal calculateCurrentAmount(Wallet wallet);
}
