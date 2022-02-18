package org.example.calculator.common;

import org.example.calculator.operations.AbstractOperation;
import org.example.calculator.operations.OperationNum;

import java.util.List;
import java.util.Stack;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-18
 * @time: 19:47
 * @desc:
 */
public class UndoStack {
    //undo stack
    private static Stack<OperationNum> undoStack = new Stack<>();

    public static void push(OperationNum item) {
        undoStack.push(item);
    }

    public static void push(List<OperationNum> items) {
        for (OperationNum item : items) {
            undoStack.push(item);
        }
    }

    public static OperationNum pop() {
        return undoStack.pop();
    }

    public static Stack<OperationNum> getUndoStack() {
        return undoStack;
    }
}
