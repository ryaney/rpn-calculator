package org.example.calculator;

import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;
import org.example.calculator.operations.AddOperator;
import org.example.calculator.operations.OperationNum;

import java.util.List;
import java.util.Stack;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 23:53
 * @desc:
 */
public class Parser {

    public void parseAndExecute(List<String> cmdIn) {

        //用于解析命令
        Stack<String> cmdLine = new Stack<>();

        for (String operation : cmdIn) {
            cmdLine.push(operation);

            //解析操作符
            OperatorEnum operatorEnum = OperatorEnum.getOperator(operation);
            switch (operatorEnum) {
                case ADD:
                    AddOperator addOperator = new AddOperator(operatorEnum).parse(operation);
                    CmdStack.push(addOperator.execute());
                    UndoStack.push(addOperator.execute());
                    break;
                case MINUS:
                case MULTIPLY:
                case DIVIDE:
                case UNDO:
                case CLEAR:
                case NUM:
                    //解析操作数
                    OperationNum operationNum = new OperationNum().parse(operation);
                    CmdStack.push(operationNum.execute());
                    UndoStack.push(operationNum.undo());
                    break;
                default:
                    break;
            }
        }
    }
}
