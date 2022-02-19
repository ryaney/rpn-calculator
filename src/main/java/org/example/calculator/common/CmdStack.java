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
    private static Stack<OperationNum> cmdStack = new Stack<OperationNum>() {
        @Override
        public String toString() {
            String string = "";
            for (int i = 0; i < elementCount; i++) {
                string += elementData[i] + " ";
            }
            return string;
        }
    };

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

    public static int size() {
        return cmdStack.size();
    }

    public static void clear() {
        try {
            cmdStack.clear();
        } catch (EmptyStackException e) {
            throw new CalculatorException(ErrorCodeEnum.CMD_STACK_ILLEGAL);
        }
    }

    public static boolean empty() {
        return cmdStack.empty();
    }

    public static OperationNum peek() {
        return cmdStack.peek();
    }

    /**
     * 打印运行时栈
     */
    public static void printCmdStack() {
        System.out.println("stack: " + cmdStack);
    }
}
