package org.example.calculator.operations;

import org.example.calculator.OperatorEnum;
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
        return "AbstractOperation{" +
                "operator='" + operator + '\'' +
                '}';
    }
}
