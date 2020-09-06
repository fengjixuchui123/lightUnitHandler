package com.seven.biz.handler.impl;

import com.seven.bean.NotifyReq;
import com.seven.bean.NotifyResp;
import com.seven.biz.handler.BasesHandler;
import com.seven.context.BaseContext;

public class NotifyFinallyHandler implements BasesHandler<NotifyReq, NotifyResp> {
    @Override
    public void handle(BaseContext<NotifyReq, NotifyResp> context) {
        System.out.println("NotifyFinallyHandler");

    }

    @Override
    public boolean ignoreFinnalyResult() {
        return false;
    }
}
