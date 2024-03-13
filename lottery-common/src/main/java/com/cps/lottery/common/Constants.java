package com.cps.lottery.common;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 15:01
 * @OtherDescription: Other things
 */
public class Constants {

    public enum ResponseCode{
        SUCCESS("0000","成功"),
        UN_ERROR("0001","未知失败"),
        ILLEGAL_PARAMETER("0002","非法参数"),
        INDEX_DUP("0003","主键冲突");

        private String code;
        private String info;

        ResponseCode(String code, String info){
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    /**
     * 抽奖策略模式：总体概率、单项概率
     * -场景A：10%、B：40%、C:50%
     * 单项概率：如果A抽空之后，B和C的概率不变，依然分别占总值的40%、50%,而剩下的10%则为未中奖
     * 总体概率：如果A抽空之后，B和C的奖品概率发生变化，占剩余奖品概率的4/（4+5）、5/（4+5），就是B奖品和C奖品按照4:5的比例
     * */
    public enum StrategyMode {
        SINGLE(1, "单项概率"),

        ENTIRETY(2, "总体概率");

        private Integer code;
        private String info;


        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


    /** 中奖状态：0未中奖、1已中奖、2兜底奖  */
    public enum DrawState{
        FAIL(0,"未中奖"),
        SUCCESS(1,"中奖"),
        COVER(2,"兜底奖");


        private Integer code;
        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


    /**
     * 发奖状态：0等待发奖、1发奖成功、2发奖失败
     */
    public enum AwardState {

        /**
         * 等待发奖
         */
        WAIT(0, "等待发奖"),

        /**
         * 发奖成功
         */
        SUCCESS(1, "发奖成功"),

        /**
         * 发奖失败
         */
        FAILURE(2, "发奖失败");

        private Integer code;
        private String info;

        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public enum AwardType{


        //文字描述
        DESC(1,"文字描述"),

        //兑换码
        RedeemCodeGoods(2,"兑换码"),

        //优惠券
        CouponGoods(3,"优惠券"),

        //实物奖品
        PhysicalGoods(4, "实物奖品");


        private Integer code;
        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
