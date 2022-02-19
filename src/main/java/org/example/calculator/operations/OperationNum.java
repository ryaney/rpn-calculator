package org.example.calculator.operations;

import org.springframework.util.Assert;

import java.util.ArrayList;
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
    public List<OperationNum> undo() {
        //操作数不能undo
        return new ArrayList<>();
    }

    @Override
    public OperationNum execute() {
        return this;
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
