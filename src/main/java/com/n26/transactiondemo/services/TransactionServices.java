package com.n26.transactiondemo.services;

import com.n26.transactiondemo.DBSimulation.TransactionDB;
import com.n26.transactiondemo.domain.Transaction;
import com.n26.transactiondemo.exceptions.InvalidTransactionException;
import com.n26.transactiondemo.models.TransactionCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by MAC Windows on 12/19/2017.
 */
@Service
public class TransactionServices {

    // this is in memory db simulation
    TransactionDB transactionDB = TransactionDB.getInstance();

    @Autowired
    AsyncServices asyncService;
    public void addTransaction(TransactionCreateModel transactionCreateModel) throws Exception {

        long currentMill = System.currentTimeMillis();
        long diff = 1000 * 60;
        if (currentMill - transactionCreateModel.getTimeStamp() > diff) {
            throw new InvalidTransactionException();
        } else {

            Transaction temp = new Transaction();
            temp.setAmount(transactionCreateModel.getAmount());
            temp.setTime(transactionCreateModel.getTimeStamp());
            transactionDB.getTransactionList().add(temp);

            //async call to calculate the summary to be ready always at o(1)
            asyncService.calculateTransactionSummary();
        }
    }
}
