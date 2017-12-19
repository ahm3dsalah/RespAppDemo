package com.n26.transactiondemo.models;

/**
 * Created by MAC Windows on 12/19/2017.
 */
public class TransactionSummaryResponseModel {

    private final double sum;
    private final double avg;
    private final double min;
    private final double max;
    private final double count;

    private static TransactionSummaryResponseModel instance = new TransactionSummaryResponseModel(0,0,0,0,0);

    private TransactionSummaryResponseModel(double sum, double avg, double min, double max, double count) {
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public static synchronized  TransactionSummaryResponseModel getInstance() {
        return instance;
    }


    public static synchronized TransactionSummaryResponseModel createTransactionSummary(double sum, double avg, double min, double max, double count) {
        instance = new TransactionSummaryResponseModel(sum, avg, min, max, count);
        return instance;
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
