package org.example.calculator.common;

import org.example.calculator.operations.AbstractOperation;

import java.util.EmptyStackException;
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
    private static Stack<AbstractOperation> undoStack = new Stack<>();

    public static void push(AbstractOperation item) {
        undoStack.push(item);
    }

    public static void push(List<? extends AbstractOperation> items) {
        for (AbstractOperation item : items) {
            undoStack.push(item);
        }
    }

    public static AbstractOperation pop() {
        try {
            return undoStack.pop();
        } catch (EmptyStackException e) {
            throw new RuntimeException("undoStack is Empty");
        }
    }

    public static Stack<AbstractOperation> getUndoStack() {
        return undoStack;
    }

    /**
     * 打印undo栈
     */
    public static void printUndoStack() {
        System.out.println("undoStack: " + undoStack);
    }
}
