package com.seven.biz.handler;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.context.BaseContext;

public interface BasesHandler <Q extends BaseReq,S extends BaseResp>{
    public void handle(BaseContext<Q, S> context);
    public  boolean ignoreFinnalyResult();

}
