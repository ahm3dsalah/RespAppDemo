package com.n26.transactiondemo.cacheServices;

import com.n26.transactiondemo.constants.CacheConstants;
import com.n26.transactiondemo.models.TransactionSummaryResponseModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAC Windows on 12/20/2017.
 */
@Component
public class TransactionCacheService {
    private static Map<String, TransactionSummaryResponseModel> store = new HashMap<String, TransactionSummaryResponseModel>();

    static {
        // initial value in case of no transactions
        store.put(CacheConstants.SUMMARY_CACHE_ID, new TransactionSummaryResponseModel(0, 0, 0, 0, 0));
    }


    @CachePut(value = "transaction_summary", key = "#cacheId")
    public TransactionSummaryResponseModel putSummary(TransactionSummaryResponseModel transactionSummaryResponseModel, String cacheId) {
        return transactionSummaryResponseModel;
    }

    @Cacheable(value = "transaction_summary", key = "#cacheId")
    public TransactionSummaryResponseModel get(String cacheId) {
        TransactionSummaryResponseModel transactionSummaryResponseModel = store.get(cacheId);
        return transactionSummaryResponseModel;
    }

    @CacheEvict(value = "transaction_summary", key = "#cacheId")
    public void evict(long cacheId) {
    }
}
