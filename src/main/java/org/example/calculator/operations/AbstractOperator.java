package org.example.calculator.operations;

import org.example.calculator.OperatorEnum;
import org.springframework.util.Assert;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 23:24
 * @desc:
 */
public abstract class AbstractOperator {

    public AbstractOperator(OperatorEnum operator) {
        Assert.notNull(operator, "operator can not be null");
        this.operator = operator;
    }

    protected OperatorEnum operator;

    public abstract Double process();



    @Override
    public String toString() {
        return "AbstractOperation{" +
                "operator='" + operator + '\'' +
                '}';
    }
}
