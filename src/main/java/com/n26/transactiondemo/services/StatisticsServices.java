package com.n26.transactiondemo.services;

import com.n26.transactiondemo.DBSimulation.TransactionDB;
import com.n26.transactiondemo.models.TransactionSummaryResponseModel;
import org.springframework.stereotype.Service;

/**
 * Created by MAC Windows on 12/19/2017.
 */
@Service
public class StatisticsServices {

    TransactionDB transactionDB = TransactionDB.getInstance();
    public TransactionSummaryResponseModel getTransactionsSummary(){
        return TransactionSummaryResponseModel.getInstance();
    }
}
