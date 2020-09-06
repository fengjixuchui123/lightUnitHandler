package com.seven.biz.process;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.context.BaseContext;

public interface BaseProcess <Q extends BaseReq, S extends BaseResp>{
    public void process(BaseContext<Q, S> context);

}
