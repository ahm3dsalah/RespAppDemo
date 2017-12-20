package com.n26.transactiondemo.controllers;

import com.n26.transactiondemo.domain.Transaction;
import com.n26.transactiondemo.models.TransactionCreateModel;
import com.n26.transactiondemo.models.TransactionSummaryResponseModel;
import com.n26.transactiondemo.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by MAC Windows on 12/19/2017.
 */
@RestController
@RequestMapping("api/transactions")
public class transactionsController {

    @Autowired
    TransactionServices transactionServices;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void  addTransaction(@RequestBody @Validated TransactionCreateModel transactionCreateModel) {
        transactionServices.addTransaction(transactionCreateModel);
    }
}
