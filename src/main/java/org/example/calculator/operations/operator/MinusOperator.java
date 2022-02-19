package org.example.calculator.operations.operator;

import org.example.calculator.operations.OperatorEnum;
import org.example.calculator.operations.OperationNum;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 09:26
 * @desc:
 */
public class MinusOperator extends AbstractBinaryOperator {

    public MinusOperator(OperatorEnum operator) {
        super(operator);
    }

    @Override
    public OperationNum execute() {
        return new OperationNum(num0 - num1);
    }

    @Override
    public List<OperationNum> undo() {
        OperationNum[] mums = new OperationNum[] {new OperationNum(num0), new OperationNum(num1)};
        return Arrays.asList(mums);
    }

    @Override
    public MinusOperator parse(String symbol) {
        super.parse(symbol);
        return this;
    }
}
