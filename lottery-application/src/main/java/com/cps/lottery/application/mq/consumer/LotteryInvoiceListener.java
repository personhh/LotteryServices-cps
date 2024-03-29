package com.cps.lottery.application.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.activity.model.vo.InvoiceVO;
import com.cps.lottery.domain.award.model.req.GoodsReq;
import com.cps.lottery.domain.award.model.res.DistributionRes;
import com.cps.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.cps.lottery.domain.award.service.goods.IDistributionGoods;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/28 13:47
 * @OtherDescription: Other things
 */

@Component
public class LotteryInvoiceListener {


    private Logger logger = LoggerFactory.getLogger(LotteryInvoiceListener.class);

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @KafkaListener(topics = "lottery_invoice", groupId = "lottery")
    public void onMessage(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        Optional<?> message = Optional.ofNullable(record.value());

        //判断消息是否存在
        if(!message.isPresent()){
            return;
        }

        //处理MQ消息
        try{
            //1.转化对象
            InvoiceVO invoiceVO = JSON.parseObject((String) message.get(), InvoiceVO.class);

            //2.获取发送奖品工厂，执行发奖
            IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(invoiceVO.getAwardType());
            DistributionRes distributionRes = distributionGoodsService.doDistribution(new GoodsReq(invoiceVO.getuId(), invoiceVO.getOrderId(), invoiceVO.getAwardId(), invoiceVO.getAwardName(), invoiceVO.getAwardContent()));

            //段言判断
            Assert.isTrue(Constants.AwardState.SUCCESS.getCode().equals(distributionRes.getCode()), distributionRes.getInfo());
            //打印日志
            logger.info("消息MQ消息，成功完成： topic: {}, bizId: {}, 发奖结果：{}",topic, invoiceVO.getuId(), JSON.toJSONString(distributionRes));

            //消息消费完成
            ack.acknowledge();
        }catch (Exception e){
            //发送环节失败，消息重试。所有到环节、发货、更新等，都需要保证幂的等
            logger.error("消费MQ消息，失败 topic：{}, message: {}", topic, message.get());
            throw e;
        }
    }
}
