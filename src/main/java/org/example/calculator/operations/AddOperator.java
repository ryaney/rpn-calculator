package org.example.calculator.operations;

import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 23:28
 * @desc:
 */
public class AddOperator extends AbstractBinaryOperator {

    public AddOperator(OperatorEnum operator) {
        super(operator);
    }

    @Override
    protected OperationNum execute() {
        return new OperationNum(num1 + num0);
    }

    @Override
    protected List<OperationNum> undo() {
        CmdStack.pop();
        OperationNum[] mums = new OperationNum[] {new OperationNum(num0), new OperationNum(num1)};
        return Arrays.asList(mums);
    }

    @Override
    public void process() {
        CmdStack.push(this.execute());
        UndoStack.push(this);
    }

    @Override
    public AddOperator parse(String symbol) {
        super.parse(symbol);
        return this;
    }
}
