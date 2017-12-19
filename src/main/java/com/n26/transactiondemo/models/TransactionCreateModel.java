package com.n26.transactiondemo.models;

import javax.validation.constraints.NotNull;

/**
 * Created by MAC Windows on 12/19/2017.
 */
public class TransactionCreateModel {

    @NotNull
    private Double amount;

    @NotNull
    private Long timeStamp;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "TransactionCreateModel{" +
                "amount=" + amount +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
