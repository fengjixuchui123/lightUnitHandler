package com.seven.biz.handler.impl;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.NotifyReq;
import com.seven.bean.NotifyResp;
import com.seven.biz.handler.BasesHandler;
import com.seven.constant.TransConstant;
import com.seven.context.BaseContext;
import com.seven.context.NotifyContext;

public class NotifyStep2Handler implements BasesHandler<NotifyReq, NotifyResp> {
    @Override
    public void handle(BaseContext<NotifyReq, NotifyResp> context) {
        System.out.println("notify handler step2");
        NotifyContext notifyContext = (NotifyContext) context;
        NotifyResp notifyResp = new NotifyResp();
        notifyResp.setRespCode(TransConstant.ReplyCode.RESP_0000.getCode());
        notifyContext.setResponse(notifyResp);

    }

    @Override
    public boolean ignoreFinnalyResult() {
        return false;
    }

}
