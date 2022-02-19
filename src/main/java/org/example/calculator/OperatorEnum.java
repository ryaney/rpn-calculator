package org.example.calculator;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 23:31
 * @desc:
 */
public enum OperatorEnum {
    /**
     * add operator
     */
    ADD("add", "+", "add operator"),

    MINUS("minus", "-", "minus operator"),

    MULTIPLY("multiply", "*", "multiply operator"),

    DIVIDE("divide", "/", "divide operator"),

    SQRT("sqrt", "sqrt", "sqrt operator"),

    UNDO("undo", "undo", "undo operator"),

    CLEAR("clear", "clear", "clear operator"),

    NUM("number", "number", "number"),

    OTHER("other", "other", "other operator");

    /**
     * operator
     */
    private String operator;

    /**
     * symbol
     */
    private String symbol;

    /**
     * description
     */
    private String description;

    OperatorEnum(String operator, String symbol, String description) {
        this.operator = operator;
        this.symbol = symbol;
        this.description = description;
    }

    /**
     * 根据操作符映射操作类型
     * @param symbol
     * @return {@link OperatorEnum}
     */
    public static OperatorEnum getOperator(String symbol) {
        for (OperatorEnum value : values()) {
            if (StringUtils.equals(value.symbol, symbol) && !StringUtils.equals(symbol, NUM.symbol)) {
                return value;
            }
        }

        try {
            Double.parseDouble(symbol);
            return NUM;
        } catch (NumberFormatException e) {
            throw  new RuntimeException("un supported symbol");
        }
    }

    public String getOperator() {
        return operator;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }
}
