package org.example.calculator.exception;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 11:12
 * @desc:
 */
public enum ErrorCodeEnum {
    //cmdStack empty
    CMD_STACK_ILLEGAL("CMD_STACK_ILLEGAL","cmdStack empty"),
    ADD_OPERATOR_ILLEGAL("ADD_OPERATOR_ILLEGAL","add operator illegal"),
    ADD_OPERATOR_PARAM_ILLEGAL("ADD_OPERATOR_PARAM_ILLEGAL","insucient parameters");

    private String code;
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
