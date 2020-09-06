package com.seven.transaction;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.TransactionBean;
import com.seven.constant.TransConstant.TransCode;
import com.seven.constant.TransConstant.TransType;

public interface BaseTransaction<Q extends BaseReq,S extends BaseResp> {
    TransType getType();

    TransCode getTransCode();

    S execute(TransactionBean transactionBean);

}
