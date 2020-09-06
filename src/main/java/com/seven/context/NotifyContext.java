package com.seven.context;

import com.seven.bean.NotifyReq;
import com.seven.bean.NotifyResp;

public class NotifyContext extends BaseContext<NotifyReq, NotifyResp> {
    public NotifyContext(String transType, String transCode) {
        this.setTransType(transType);
        this.setRespCode(transCode);
    }
}
