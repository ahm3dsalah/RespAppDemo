package com.n26.transactiondemo.DBSimulation;

import com.n26.transactiondemo.domain.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAC Windows on 12/19/2017.
 */
public class TransactionDB {

    private List<Transaction> transactionList = new ArrayList<>();
    private static TransactionDB instance = new TransactionDB();
    private TransactionDB() {

        transactionList = new ArrayList<Transaction>();
    }

    public static TransactionDB getInstance() {
        return instance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
