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
}
