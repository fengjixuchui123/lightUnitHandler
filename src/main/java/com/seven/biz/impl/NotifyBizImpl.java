package com.seven.biz.impl;

import com.seven.bean.NotifyReq;
import com.seven.bean.NotifyResp;
import com.seven.biz.BaseBiz;
import com.seven.biz.process.BaseProcess;
import com.seven.context.BaseContext;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class NotifyBizImpl implements BaseBiz<NotifyReq, NotifyResp> {
    private BaseProcess<NotifyReq, NotifyResp> process;

    private final static Logger logger = LoggerFactory.getLogger(NotifyBizImpl.class);
    public void biz(BaseContext<NotifyReq, NotifyResp> context) {
        logger.info("start NotifyBizImpl,context={}",context);
        process.process(context);
        logger.info("end NotifyBizImpl,context={}",context);
    }

}
