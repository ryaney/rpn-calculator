package org.example.calculator.operations;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.OperatorEnum;
import org.example.calculator.common.CmdStack;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 09:26
 * @desc:
 */
public class MinusOperator extends AbstractOperator {

    public MinusOperator(OperatorEnum operator) {
        super(operator);
    }

    private Double num1;
    private Double num0;

    @Override
    public OperationNum execute() {
        return new OperationNum(num0 - num1);
    }

    @Override
    public List<OperationNum> undo() {
        OperationNum[] mums = new OperationNum[] {new OperationNum(num0), new OperationNum(num1)};
        return Arrays.asList(mums);
    }

    /**
     * 根据cmdIn的peek element，解析操作
     *
     * @param symbol 操作
     * @return {@link MinusOperator}
     */
    @Override
    public MinusOperator parse(String symbol) {
        Assert.hasText(symbol, "operation can not be empty");
        Assert.isTrue(StringUtils.equals(symbol, operator.getSymbol()), "operator is not minus");
        num1 = CmdStack.pop().operationNum;
        Assert.notNull(num1, "operation num1 can not be null");
        num0 = CmdStack.pop().operationNum;
        Assert.notNull(num0, "operation num0 can not be null");

        return this;
    }
}
