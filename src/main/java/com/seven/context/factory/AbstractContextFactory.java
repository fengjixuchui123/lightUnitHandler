package com.seven.context.factory;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.TransactionBean;
import com.seven.context.BaseContext;

import java.lang.reflect.ParameterizedType;

public abstract  class AbstractContextFactory<Q extends BaseReq,S extends BaseResp> implements ContextFactory {
    protected BaseContext<Q,S> context;


    @Override
    public BaseContext<Q,S> getContext(TransactionBean transactionBean) throws Exception{
        context.setRequest((Q) transactionBean.getRequest());
/*        Class<S> sClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        context.setResponse(sClass.newInstance());*/
        return initContext();
    }


    @Override
    public BaseContext<Q,S> getContext() throws Exception{
        return context;
    }

    @Override
    public BaseResp toResponse(BaseContext context) throws Exception {
        S res = (S) toResBean(context);
        return res;
    }



    protected abstract Q getReqBean(TransactionBean transactionBean) throws Exception;


    protected abstract S toResBean(BaseContext<Q,S> context) throws Exception;


    protected BaseContext<Q,S> initContext(){
        return context;
    }
}
