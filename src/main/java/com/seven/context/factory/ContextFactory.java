package com.seven.context.factory;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.TransactionBean;
import com.seven.context.BaseContext;

public interface ContextFactory <Q extends BaseReq,S extends BaseResp> {

    public BaseContext<Q,S> getContext() throws Exception;

    public BaseContext<Q,S> getContext(TransactionBean transactionBean) throws Exception;

    public S toResponse(BaseContext<Q,S> context) throws Exception;
}
