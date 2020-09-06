package com.seven.transaction;


import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.bean.TransactionBean;
import com.seven.biz.BaseBiz;
import com.seven.context.BaseContext;
import com.seven.context.factory.ContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractBaseTransaction<Q extends BaseReq, S extends BaseResp> implements BaseTransaction {
    private static final Logger logger = LoggerFactory.getLogger(AbstractBaseTransaction.class);

    private BaseBiz<Q, S> baseBiz;

    public S execute(TransactionBean transactionBean) {
        logger.info("start to exexute,transCode={},transType={}", transactionBean.getTransCode(),transactionBean.getTransCode());
        ContextFactory<Q , S > contextFactory = getContextFactory();
        S response = null;
        try {
            BaseContext<Q, S> context = contextFactory.getContext(transactionBean);
            baseBiz.biz(context);
            response = contextFactory.toResponse(context);
        } catch (Exception e) {
            //todo set respcode and respMsg
            throw new RuntimeException("Error");
        }

        logger.info("start to exexute,transCode={},transType={}", transactionBean.getTransCode(),transactionBean.getTransCode());
        return response;
    }

    protected abstract ContextFactory<Q, S> getContextFactory();

    public BaseBiz<Q, S> getBaseBiz() {
        return baseBiz;
    }

    public void setBaseBiz(BaseBiz<Q, S> baseBiz) {
        this.baseBiz = baseBiz;
    }
}
