package com.seven.biz;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.context.BaseContext;

public interface BaseBiz<Q extends BaseReq,S extends BaseResp> {
    public void biz(BaseContext<Q,S> context);
}
