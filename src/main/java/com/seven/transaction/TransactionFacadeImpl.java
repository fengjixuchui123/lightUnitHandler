package com.seven.transaction;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.TransactionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TransactionFacadeImpl<Q extends BaseReq,S extends BaseResp> implements TransactionFacade {
    private static final String SPERATOR = "-";
    private static final Logger logger = LoggerFactory.getLogger(TransactionFacadeImpl.class);
    private Map<String, BaseTransaction> baseTransactionMap = new HashMap<String, BaseTransaction>();

    @Override
    public S execute(BaseReq request) {
        logger.info("TransactionFacadeImpl.execute start");
        TransactionBean<Q> transactionBean = new TransactionBean<>();
        transactionBean.setRequest((Q) request);
        transactionBean.setTransCode(request.getTransCode());
        transactionBean.setTransType(request.getTransType());
        Assert.notNull(transactionBean.getTransCode(),"transCode is null");
        String key = "";

        if (Objects.isNull(transactionBean.getTransType())){
            key = transactionBean.getTransCode();
        }else {
            key = transactionBean.getTransCode() + SPERATOR + transactionBean.getTransType();
        }
        logger.info("TransactionFacadeImpl.execute,key={}",key);
        BaseTransaction baseTransaction = baseTransactionMap.get(key);
        if (Objects.isNull(baseTransaction)){
            throw new RuntimeException("transcation configure miss");
        }
        S response = (S) baseTransaction.execute(transactionBean);
        return response;
    }

    public void setBaseTransactionMap(Map baseTransactionMap) {
        this.baseTransactionMap = baseTransactionMap;
    }

    public Map getBaseTransactionMap() {
        return baseTransactionMap;
    }

}
