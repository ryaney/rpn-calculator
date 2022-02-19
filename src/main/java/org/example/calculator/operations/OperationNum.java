package org.example.calculator.operations;

import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-18
 * @time: 08:32
 * @desc:
 */
public class OperationNum extends AbstractOperation {

    /**
     * 操作数
     */
    protected Double operationNum;

    public OperationNum() {
        super();
    }

    public OperationNum(Double operationNum) {
        super();
        this.operationNum = operationNum;
    }

    @Override
    protected List<OperationNum> undo() {
        CmdStack.pop();
        return null;
    }

    @Override
    protected OperationNum execute() {
        return this;
    }

    @Override
    public void process() {
        CmdStack.push(this.execute());
        UndoStack.push(this);
    }

    /**
     * 根据cmdIn的peek element，解析操作数
     *
     * @param operation 操作
     * @return {@link OperationNum}
     */
    @Override
    public OperationNum parse(String operation) {
        Assert.hasText(operation, "operationNum can not be empty");
        operationNum = Double.parseDouble(operation);
        return this;
    }

    @Override
    public String toString() {
        return operationNum.toString();
    }

    public Double getOperationNum() {
        return operationNum;
    }
}
