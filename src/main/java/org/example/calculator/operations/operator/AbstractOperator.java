package org.example.calculator.operations.operator;

import org.example.calculator.operations.OperatorEnum;
import org.example.calculator.operations.AbstractOperation;
import org.springframework.util.Assert;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 23:24
 * @desc:
 */
public abstract class AbstractOperator extends AbstractOperation {

    public AbstractOperator(OperatorEnum operator) {
        super();
        Assert.notNull(operator, "operator can not be null");
        this.operator = operator;
    }

    protected OperatorEnum operator;

    @Override
    public String toString() {
        return operator.getOperator();
    }
}
