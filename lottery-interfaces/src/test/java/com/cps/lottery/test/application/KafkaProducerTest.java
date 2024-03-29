package com.cps.lottery.test.application;

import com.cps.lottery.application.mq.producer.KafkaProducer;
import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.activity.model.vo.InvoiceVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: kafka基础测试
 * @date 2024/3/27 16:04
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerTest {

    private Logger logger = LoggerFactory.getLogger(KafkaProducerTest.class);

    @Resource
    private KafkaProducer kafkaProducer;

    @Test
    public void test_send() throws InterruptedException{

        InvoiceVO invoice = new InvoiceVO();
        invoice.setuId("Uhdgkw766120d");
        invoice.setOrderId(1444540456057864192L);
        invoice.setAwardId("3");
        invoice.setAwardType(Constants.AwardType.DESC.getCode());
        invoice.setAwardName("Code");
        invoice.setAwardContent("苹果电脑");
        invoice.setShippingAddress(null);
        invoice.setExtInfo(null);

        kafkaProducer.sendLotteryInvoice(invoice);
        while(true){
            Thread.sleep(10000);
        }
    }
}
