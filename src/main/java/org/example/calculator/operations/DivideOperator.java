package org.example.calculator.operations;

import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;
import org.example.calculator.exception.CalculatorException;
import org.example.calculator.exception.ErrorCodeEnum;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 09:31
 * @desc:
 */
public class DivideOperator extends AbstractBinaryOperator {

    public DivideOperator(OperatorEnum operator) {
        super(operator);
    }

    @Override
    public OperationNum execute() {
        return new OperationNum(num0 / num1);
    }

    @Override
    public List<OperationNum> undo() {
        try {
            CmdStack.pop();
            OperationNum[] mums = new OperationNum[]{new OperationNum(num0), new OperationNum(num1)};
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

    @Override
    public AbstractBinaryOperator parse(String symbol) {
        super.parse(symbol);
        return this;
    }
}
