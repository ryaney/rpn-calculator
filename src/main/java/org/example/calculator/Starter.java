package org.example.calculator;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.common.CmdStack;
import org.example.calculator.common.ErrorStack;
import org.example.calculator.common.UndoStack;
import org.example.calculator.parse.Parser;

import java.util.*;

/**
 * @Author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 22:47
 * @desc: the entrance of this execute
 */
public class Starter {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.interactive();
    }

    /**
     * 命令行交互
     * quit命令退出
     */
    public void interactive() {
        while (true) {
            System.out.print("\n>>  ");
            /**
             * start this process
             * eg:
             *  >> 5  2 + undo undo 6 -
             *  [errorMsg]
             *  stack: [5 2]
             *  >>quit
             *  then exit this process
             */
            String cmdInput = scanner.nextLine();
            if (StringUtils.isBlank(cmdInput)) {
                continue;
            }
            if (StringUtils.equals(cmdInput, "quit")) {
                System.exit(0);
            }
            start(cmdInput);
        }
    }

    public void start(String inputLine) {

        Parser parser = new Parser();
        parser.parseAndExecute(inputLine);

        //异常栈打印完成后，清空异常栈
        ErrorStack.printErrorStack();
        ErrorStack.clear();
        CmdStack.printCmdStack();
        UndoStack.printUndoStack();
    }
}
