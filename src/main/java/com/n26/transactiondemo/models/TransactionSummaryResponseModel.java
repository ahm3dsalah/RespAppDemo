package com.n26.transactiondemo.models;

/**
 * Created by MAC Windows on 12/19/2017.
 */
public class TransactionSummaryResponseModel {

    private double sum = 0;
    private double avg = 0;
    private double min = 0;
    private double max = 0;
    private double count = 0;

    public TransactionSummaryResponseModel() {

    }
    public TransactionSummaryResponseModel(double sum, double avg, double min, double max, double count) {
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getCount() {
        return count;
    }
}
