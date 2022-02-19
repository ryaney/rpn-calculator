package org.example.calculator.operations;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 13:14
 * @desc:
 */
public class ClearOperator extends AbstractOperator {

    public ClearOperator(OperatorEnum operator) {
        super(operator);
    }

    private List<OperationNum> clearNums = new ArrayList<>();

    @Override
    public OperationNum execute() {
        //保存运行时栈
        Stack<OperationNum> tempStack = new Stack<>();
        while (!CmdStack.empty()) {
            tempStack.push(CmdStack.pop());
        }
        while (!tempStack.empty()) {
            clearNums.add(tempStack.pop());
        }

        //清空运行时栈
        CmdStack.clear();
        return null;
    }

    @Override
    public List<OperationNum> undo() {
        return clearNums;
    }

    @Override
    public void process() {
        this.execute();
        UndoStack.push(this);
    }

    @Override
    public ClearOperator parse(String symbol) {
        Assert.hasText(symbol, "operation can not be empty");
        Assert.isTrue(StringUtils.equals(symbol, operator.getSymbol()), "operator is not undo");
        return this;
    }
}
