package org.example.calculator.common;

import java.util.Stack;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 12:27
 * @desc:
 */
public class ErrorStack {
    //error stack
    private static Stack<String> errorStack = new Stack<>();

    public static void push(String item) {
        errorStack.push(item);
    }

    public static void clear() {
        errorStack.clear();
    }

    public static Stack<String> getErrorStack() {
        return errorStack;
    }

    public static void printErrorStack() {
        System.out.println(errorStack);
    }
}
