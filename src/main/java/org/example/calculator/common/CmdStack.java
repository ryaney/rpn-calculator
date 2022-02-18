package org.example.calculator.common;

import org.example.calculator.operations.OperationNum;

import java.util.List;
import java.util.Stack;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-18
 * @time: 19:48
 * @desc:
 */
public class CmdStack {

    //运行时栈
    private static Stack<OperationNum> cmdStack = new Stack<>();

    public static void push(OperationNum item) {
        cmdStack.push(item);
    }

    public static void push(List<OperationNum> items) {
        for (OperationNum item : items) {
            cmdStack.push(item);
        }
    }

    public static OperationNum pop() {
        return cmdStack.pop();
    }

    public static Stack<OperationNum> getCmdStack() {
        return cmdStack;
    }
}
