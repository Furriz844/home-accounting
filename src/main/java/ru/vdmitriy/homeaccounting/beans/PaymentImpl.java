package ru.vdmitriy.homeaccounting.beans;

import ru.vdmitriy.homeaccounting.api.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class PaymentImpl implements Payment {

    private String name;

    private String uuid;

    private String categoryUuid;

    private String walletUuid;

    private String comment;

    private BigDecimal value;

    private boolean proceed;

    private boolean profit;

    private LocalDateTime date;

    public PaymentImpl() {
    }

    public PaymentImpl(String name,
                       String uuid,
                       String categoryUuid,
                       String walletUuid,
                       String comment,
                       BigDecimal value,
                       boolean proceed,
                       boolean profit,
                       LocalDateTime date) {
        this.name = name;
        this.uuid = uuid;
        this.categoryUuid = categoryUuid;
        this.walletUuid = walletUuid;
        this.comment = comment;
        this.value = value;
        this.proceed = proceed;
        this.profit = profit;
        this.date = date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;

    }

    @Override
    public String getCategoryUuid() {
        return categoryUuid;
    }

    @Override
    public void setCategoryUuid(String categoryUuid) {
        this.categoryUuid = categoryUuid;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean isProceed() {
        return proceed;
    }

    @Override
    public void setProceed(boolean proceed) {
        this.proceed = proceed;
    }

    @Override
    public boolean isProfit() {
        return profit;
    }

    @Override
    public void setProfit(boolean profit) {
        this.profit = profit;
    }

    @Override
    public String getWalletUuid() {
        return walletUuid;
    }

    @Override
    public void setWalletUuid(String uuid) {
        this.walletUuid = uuid;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDateTime dateTime) {
        this.date = dateTime;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).
                append("\n").
                append(this.getUuid()).
                append("\n").
                append(this.getCategoryUuid()).
                append("\n").
                append(this.getWalletUuid()).
                append("\n").
                append(this.getComment()).
                append("\n").
                append(this.getValue()).
                append("\n").
                append(this.isProceed()).
                append("\n").
                append(this.isProfit()).
                append("\n").
                append(this.getDate());
        return sb.toString();
    }
}
