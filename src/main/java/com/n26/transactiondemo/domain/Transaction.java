package com.n26.transactiondemo.domain;

/**
 * Created by MAC Windows on 12/19/2017.
 */
public class Transaction {

    private double amount;
    private Long time;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
