package org.example.calculator.operations;

import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-18
 * @time: 00:08
 * @desc:
 */
public abstract class AbstractOperation {

    public AbstractOperation() {
    }

    /**
     * inner method,should be protected
     * @return {@link List< OperationNum >}
     */
    protected abstract List<OperationNum> undo();

    /**
     * inner method,should be protected
     * @return {@link OperationNum}
     */
    protected abstract OperationNum execute();

    /**
     * entrance method
     */
    public abstract void process();

    public abstract AbstractOperation parse(String operation);
}
