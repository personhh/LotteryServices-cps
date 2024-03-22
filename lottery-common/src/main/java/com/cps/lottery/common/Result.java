package com.cps.lottery.common;

import java.io.Serializable;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 14:58
 * @OtherDescription: Other things
 */
public class Result implements Serializable {

    private static final long serialVersionUID = -3826891916021780628L;
    private String code;
    private String info;

    public static Result buildResult(Constants.ResponseCode code){
        return new Result(code.getCode(), code.getInfo());
    }
    public static Result buildResult(Constants.ResponseCode code, String info){
        return new Result(code.getCode(), info);
    }

    public static Result buildResult(Constants.ResponseCode code,Constants.ResponseCode info){
        return new Result(code.getCode(), info.getInfo());
    }
    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }
    public static Result buildSuccessResult(){
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    public static Result buildSuccessResult(String info){
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), info);
    }

    public static Result buildFailResult(){
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
    }

    /**
     * 失败方法
     */
    public static Result buildFailResult(String info){
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), info);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
