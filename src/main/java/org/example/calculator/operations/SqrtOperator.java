package org.example.calculator.operations;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;
import org.example.calculator.exception.CalculatorException;
import org.example.calculator.exception.ErrorCodeEnum;
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
    protected OperationNum execute() {
        return new OperationNum(Math.sqrt(num0));
    }

    @Override
    protected List<OperationNum> undo() {
        try {
            CmdStack.pop();
            OperationNum[] mums = new OperationNum[]{new OperationNum(num0)};
            return Arrays.asList(mums);
        } catch (CalculatorException e) {
            throw new CalculatorException(ErrorCodeEnum.OPERATOR_PARAM_ILLEGAL);
        }
    }

    @Override
    public void process() {
        CmdStack.push(this.execute());
        UndoStack.push(this);
    }

    /**
     * 根据cmdIn的peek element，解析操作
     *
     * @param symbol 操作
     * @return {@link SqrtOperator}
     */
    @Override
    public SqrtOperator parse(String symbol) {
        try {
            Assert.isTrue(CmdStack.size() >= 1, "operation size can not less than 1");
            Assert.hasText(symbol, "operation can not be empty");
            Assert.isTrue(StringUtils.equals(symbol, operator.getSymbol()), "operator is not sqrt");
            num0 = CmdStack.pop().getOperationNum();
            Assert.notNull(num0, "operation num0 can not be null");
        } catch (RuntimeException e) {
            throw new CalculatorException(ErrorCodeEnum.OPERATOR_PARAM_ILLEGAL);
        }

        return this;
    }
}
