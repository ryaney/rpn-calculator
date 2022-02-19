package org.example.calculator.operations.operator;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.operations.OperatorEnum;
import org.example.calculator.common.CmdStack;
import org.example.calculator.operations.OperationNum;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 09:33
 * @desc:
 */
public class SqrtOperator extends AbstractOperator {

    public SqrtOperator(OperatorEnum operator) {
        super(operator);
    }

    private Double num0;

    @Override
    public OperationNum execute() {
        return new OperationNum(Math.sqrt(num0));
    }

    @Override
    public List<OperationNum> undo() {
        OperationNum[] mums = new OperationNum[] {new OperationNum(num0)};
        return Arrays.asList(mums);
    }

    /**
     * 根据cmdIn的peek element，解析操作
     *
     * @param symbol 操作
     * @return {@link SqrtOperator}
     */
    @Override
    public SqrtOperator parse(String symbol) {
        Assert.hasText(symbol, "operation can not be empty");
        Assert.isTrue(StringUtils.equals(symbol, operator.getSymbol()), "operator is not sqrt");
        num0 = CmdStack.pop().getOperationNum();
        Assert.notNull(num0, "operation num0 can not be null");

        return this;
    }
}
