package ru.vdmitriy.homeaccounting.api;

public interface PaymentCategory {
    String getCategoryId();

    String getName();

    boolean isProfit();
}
