package com.seven.transaction.impl;

import com.seven.bean.NotifyReq;
import com.seven.bean.NotifyResp;
import com.seven.biz.impl.NotifyBizImpl;
import com.seven.constant.TransConstant.TransCode;
import com.seven.constant.TransConstant.TransType;
import com.seven.context.factory.ContextFactory;
import com.seven.context.factory.NotifyContextFactory;
import com.seven.transaction.AbstractBaseTransaction;

public class NotifyTranscation extends AbstractBaseTransaction<NotifyReq, NotifyResp> {

    protected ContextFactory<NotifyReq, NotifyResp> getContextFactory() {
        return new NotifyContextFactory(getType().getCode(), getTransCode().getCode());
    }

    public TransType getType() {
        return TransType.TRANSTYPE_01;
    }

    public TransCode getTransCode() {
        return TransCode.RECEVIVE_NOTIFY;
    }



}
