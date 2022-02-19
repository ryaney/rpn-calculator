package org.example.calculator.operations;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.OperatorEnum;
import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 09:36
 * @desc:
 */
public class UndoOperator extends AbstractOperator {

    public UndoOperator(OperatorEnum operator) {
        super(operator);
    }

    private AbstractOperation undoOp;

    private OperationNum num0;

    @Override
    public OperationNum execute() {

        List<OperationNum> operationNums = undoOp.undo();
        CmdStack.push(operationNums);
        return null;
    }

    @Override
    public List<OperationNum> undo() {
        return Arrays.asList(undoOp.execute());
    }

    /**
     * 根据cmdIn的peek element，解析操作
     *
     * @param symbol 操作
     * @return {@link UndoOperator}
     */
    @Override
    public UndoOperator parse(String symbol) {
        Assert.hasText(symbol, "operation can not be empty");
        Assert.isTrue(StringUtils.equals(symbol, operator.getSymbol()), "operator is not undo");
        //弹出运行时数据
        num0 = CmdStack.pop();
        Assert.notNull(num0, "operation num0 can not be null");
        //弹出操作符或操作数
        undoOp = UndoStack.pop();
        Assert.notNull(undoOp, "undo operator can not be null");

        return this;
    }
}
