package org.example.calculator.common;

import org.example.calculator.exception.CalculatorException;
import org.example.calculator.exception.ErrorCodeEnum;
import org.example.calculator.operations.OperationNum;
import org.springframework.util.CollectionUtils;

import java.util.EmptyStackException;
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
        if (CollectionUtils.isEmpty(items)) {
            return;
        }

        for (OperationNum item : items) {
            cmdStack.push(item);
        }
    }

    public static OperationNum pop() {
        try {
            return cmdStack.pop();
        } catch (EmptyStackException e) {
            throw new CalculatorException(ErrorCodeEnum.CMD_STACK_ILLEGAL);
        }
    }

    public static Stack<OperationNum> getCmdStack() {
        return cmdStack;
    }

    /**
     * 打印运行时栈
     */
    public static void printCmdStack() {
        System.out.println("stack: " + cmdStack);
    }
}
