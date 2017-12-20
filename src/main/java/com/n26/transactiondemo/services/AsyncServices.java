package com.n26.transactiondemo.services;

import com.n26.transactiondemo.DBSimulation.TransactionDB;
import com.n26.transactiondemo.cacheServices.TransactionCacheService;
import com.n26.transactiondemo.constants.CacheConstants;
import com.n26.transactiondemo.domain.Transaction;
import com.n26.transactiondemo.models.TransactionSummaryResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MAC Windows on 12/19/2017.
 */
@Service
public class AsyncServices {

    TransactionDB transactionDB = TransactionDB.getInstance();


    @Autowired
    TransactionCacheService transactionCacheService;
    // Run asyc to calculate summary whenever a new transaction is added
    @Async
    public void calculateTransactionSummary() {

        // the code to calculate summary

        List<Transaction> transactionsList = transactionDB.getTransactionList();
        long currentMill = System.currentTimeMillis();
        long diff = 60 * 1000;

        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        double avg = 0;
        double count = 0;


        // i am looping over all transactions everyTime since its a simulation
        // while in real situation you can get the transactions ordered from BE
        // and do some optimization to this loop breaking from it when the diff is more than 60  seconds
        for (int i = 0; i < transactionsList.size(); i++) {

            Transaction temp = transactionsList.get(i);
            if (currentMill - temp.getTime() > diff) {
                continue;
            }
            double transactionAmount = temp.getAmount();
            sum += transactionAmount;
            if (transactionAmount > max) {
                max = transactionAmount;
            }
            if (transactionAmount < min) {
                min = transactionAmount;
            }
            count++;
        }
        avg = sum / count;

        // this will be cached every Time
        transactionCacheService.putSummary(new TransactionSummaryResponseModel(sum, avg, min, max, count), CacheConstants.SUMMARY_CACHE_ID);
    }
}
