package com.seven.transaction;

import com.seven.bean.NotifyReq;
import com.seven.bean.NotifyResp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath*:/spring/applicationContext-api.xml","classpath*:/spring/applicationContext-biz.xml"})
public class TransactionFacadeImplTest {
    @Autowired
    private TransactionFacadeImpl transactionFacade;

    @Before
    public void setUp(){
        Assert.assertNotNull(transactionFacade);
    }
    @Test
    public void execute_no_resp() {
        NotifyReq req = new NotifyReq();
        req.setTransCode("001");
        req.setTransType("0001");
        transactionFacade.execute(req);

    }

    @Test
    public void execute_no_transType() {
        NotifyReq req = new NotifyReq();
        req.setTransCode("001");
        transactionFacade.execute(req);
    }

    @Test
    public void execute() {
        NotifyReq req = new NotifyReq();
        req.setTransCode("001");
        NotifyResp resp = (NotifyResp) transactionFacade.execute(req);
        Assert.assertNotNull(resp);
        Assert.assertEquals(resp.getRespCode(),"0000");

    }
}