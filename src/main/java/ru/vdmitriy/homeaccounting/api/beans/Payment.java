package ru.vdmitriy.homeaccounting.api.beans;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Payment {

    String getName();

    void setName(String name);

    String getUuid();

    void setUuid(String UUID);

    String getCategoryUuid();

    void setCategoryUuid(String categoryUuid);

    String getComment();

    void setComment(String comment);

    void setValue(BigDecimal value);

    BigDecimal getValue();

    boolean isProceed();

    void setProceed(boolean proceed);

    boolean isProfit();

    void setProfit(boolean profit);

    String getWalletUuid();

    void setWalletUuid(String UUID);

    LocalDateTime getDate();

    void setDate(LocalDateTime dateTimee);

}
