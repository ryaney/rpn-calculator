package org.example.calculator.operations;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.common.CmdStack;
import org.example.calculator.exception.CalculatorException;
import org.example.calculator.exception.ErrorCodeEnum;
import org.springframework.util.Assert;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 12:42
 * @desc:
 */
public abstract class AbstractBinaryOperator extends AbstractOperator {

    public AbstractBinaryOperator(OperatorEnum operator) {
        super(operator);
    }

    protected Double num1;
    protected Double num0;

    /**
     * 根据cmdIn的peek element，解析操作
     *
     * @param symbol 操作
     * @return {@link AddOperator}
     */
    @Override
    public AbstractBinaryOperator parse(String symbol) {
        Assert.hasText(symbol, "operation can not be empty");
        Assert.isTrue(StringUtils.equals(symbol, operator.getSymbol()), "operator is not match");
        try {
            num1 = CmdStack.pop().getOperationNum();
            Assert.notNull(num1, "operation num1 can not be null");
            num0 = CmdStack.pop().getOperationNum();
            Assert.notNull(num0, "operation num0 can not be null");
        } catch (CalculatorException e) {
            throw new CalculatorException(ErrorCodeEnum.OPERATOR_PARAM_ILLEGAL);
        }

        return this;
    }
}
