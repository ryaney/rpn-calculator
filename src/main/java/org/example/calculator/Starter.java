package org.example.calculator;

import org.apache.commons.lang3.StringUtils;
import org.example.calculator.common.CmdStack;
import org.example.calculator.common.ErrorStack;
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

        help();
        while (true) {
            System.out.print("\n>>  ");
            /**
             * start this process
             * eg:
             *  >> 5  2 + undo undo 6 -
             *  [errorMsg]
             *  stack: 5 2
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
    }

    private void help() {
        System.out.println("==============================================================");
        System.out.println("***              RPN-Calculator Version: v1.000            ***");
        System.out.println("***   HomePage: https://github.com/ryaney/rpn-calculator   ***");
        System.out.println("***  命令行如下：                                            ***");
        System.out.println("***  >>1 2 3 * 5 + * * 6 5                                 ***");
        System.out.println("***  operator * (position: 15): insufficient parameters    ***");
        System.out.println("***  stack: 11                                             ***");
        System.out.println("***  >>quit                                                ***");
        System.out.println("***  >>Process finished with exit code 0                   ***");
        System.out.println("==============================================================");
    }
}
