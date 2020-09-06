package com.seven.transaction;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.TransactionBean;

public interface TransactionFacade<Q extends BaseReq,S extends BaseResp> {
    public S execute(Q request);

}
