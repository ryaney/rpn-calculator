package org.example.calculator.operations;

import org.example.calculator.OperatorEnum;
import org.springframework.util.Assert;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 23:28
 * @desc:
 */
public class AddOperator extends AbstractOperator {

    public AddOperator(OperatorEnum operator, Double num1, Double num0) {
        super(operator);
        Assert.notNull(num0, "operation num0 can not be null");
        Assert.notNull(num1, "operation num1 can not be null");
        this.num1 = num1;
        this.num0 = num0;
    }

    private Double num1;
    private Double num0;

    @Override
    public Double process() {
        return num1 + num0;
    }
}
