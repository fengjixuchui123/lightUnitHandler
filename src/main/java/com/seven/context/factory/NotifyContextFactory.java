package com.seven.context.factory;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.TransactionBean;
import com.seven.context.BaseContext;
import com.seven.context.NotifyContext;

public class NotifyContextFactory<NotifyReq extends BaseReq,NotifyResp extends BaseResp> extends AbstractContextFactory {
    public NotifyContextFactory(String transType, String transCode) {
        context = new NotifyContext(transType,transCode);
    }

    @Override
    protected NotifyReq getReqBean(TransactionBean transactionBean) throws Exception {
        return null;
    }

    @Override
    protected NotifyResp toResBean(BaseContext context) throws Exception {
        return null;
    }

    @Override
    protected BaseContext initContext() {
        return super.initContext();
    }
}
