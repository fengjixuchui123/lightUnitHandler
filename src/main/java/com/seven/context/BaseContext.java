package com.seven.context;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import lombok.Data;

@Data
public class BaseContext <Q extends BaseReq,S extends BaseResp> {
    private String transCode;
    private String transType;
    private String respCode;
    private String respMsg;
    private Q request;
    private S response;

    private ExceptionHandlerInfo exceptionHandlerInfo;
    private FinallyHandlerInfo finallyHandlerInfo;
}
