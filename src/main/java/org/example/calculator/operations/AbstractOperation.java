package org.example.calculator.operations;

import java.util.List;
import java.util.Stack;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-18
 * @time: 00:08
 * @desc:
 */
public abstract class AbstractOperation {

    public AbstractOperation() {
    }

    public abstract List<OperationNum> undo();

    public abstract OperationNum execute();

    public abstract AbstractOperation parse(String operation);
}
