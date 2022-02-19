package org.example.calculator.exception;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 11:19
 * @desc:
 */
public class CalculatorException extends RuntimeException {

    public CalculatorException(ErrorCodeEnum e) {
        super(e.getDesc());
    }
}
