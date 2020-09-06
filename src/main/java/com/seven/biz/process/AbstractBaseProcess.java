package com.seven.biz.process;

import com.seven.bean.BaseReq;
import com.seven.bean.BaseResp;
import com.seven.biz.handler.BasesHandler;
import com.seven.constant.TransConstant.ReplyCode;
import com.seven.context.BaseContext;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

@Data
public abstract class AbstractBaseProcess<Q extends BaseReq,S extends BaseResp>  implements BaseProcess {
    private final static Logger logger = LoggerFactory.getLogger(AbstractBaseProcess.class);

    private List<BasesHandler<Q, S>> handlers;
    private List<BasesHandler<Q, S>> exceptionHandlers;
    private List<BasesHandler<Q, S>> finallyHandlers;

    @Override
    public void process(BaseContext context){
        try{
            if(handlers != null){
                for(BasesHandler<Q, S> handler : handlers){
                    logger.info("start to execute handler->{}",handler.getClass().getSimpleName());
                    handler.handle(context);
                    if(!Objects.equals(ReplyCode.SUCCESS.getCode(),context.getRespCode())){
                        throw new Exception("respCode:" + context.getRespCode() + ",respMsg" + context.getRespMsg());
                    }
                    logger.info("end to execute handler->{}",handler.getClass().getSimpleName());
                }
            }
        } catch(Exception e){
            if(exceptionHandlers != null){
                for(BasesHandler<Q, S> handler : exceptionHandlers){
                    logger.info("start to execute exception handler->{}",handler.getClass().getSimpleName());
                    handler.handle(context);
                    logger.info("end to execute exception handler->{}",handler.getClass().getSimpleName());

                }
            }
        } finally{
            try{
                if(finallyHandlers != null){
                    for(BasesHandler<Q, S> handler : finallyHandlers){
                        logger.info("start to execute finally handler->{}",handler.getClass().getSimpleName());
                        handler.handle(context);
                        logger.info("end to execute finally handler->{}",handler.getClass().getSimpleName());

                    }
                }
            }catch(Exception e){
                // TODO: 2020/9/6   add cat info
            }
        }
    }
}
