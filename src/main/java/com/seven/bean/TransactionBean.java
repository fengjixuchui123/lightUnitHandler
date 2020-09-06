package com.seven.bean;

import lombok.Data;

@Data
public class TransactionBean<Q extends BaseReq> {
    private String transCode;
    private String transType;
    private Q request;
}
