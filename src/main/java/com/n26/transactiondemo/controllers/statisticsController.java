package com.n26.transactiondemo.controllers;

import com.n26.transactiondemo.cacheServices.TransactionCacheService;
import com.n26.transactiondemo.constants.CacheConstants;
import com.n26.transactiondemo.models.TransactionSummaryResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MAC Windows on 12/19/2017.
 */
@RestController
@RequestMapping("api/statistics")
public class statisticsController {

    @Autowired
    TransactionCacheService transactionCacheService;

    @RequestMapping(method = RequestMethod.GET)
    public TransactionSummaryResponseModel getTransactionsSummary(){
        return transactionCacheService.get(CacheConstants.SUMMARY_CACHE_ID);
    }
}
