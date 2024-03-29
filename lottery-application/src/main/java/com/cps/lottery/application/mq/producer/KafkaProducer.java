package com.cps.lottery.application.mq.producer;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.domain.activity.model.vo.InvoiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;


import javax.annotation.Resource;

/**
 * @author cps
 * @description: MQ消息发送服务
 * @date 2024/3/28 11:57
 * @OtherDescription: Other things
 */

@Component
public class KafkaProducer {

    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public static final String TOPIC_INVOICE = "lottery_invoice";

    public ListenableFuture<SendResult<String, Object>> sendLotteryInvoice(InvoiceVO invoice){
        String objJson = JSON.toJSONString(invoice);
        logger.info("发送MQ消息 topic：{} bizId: {} message: {}", TOPIC_INVOICE, invoice.getuId(), objJson);
        return kafkaTemplate.send(TOPIC_INVOICE, objJson);
    }
}
