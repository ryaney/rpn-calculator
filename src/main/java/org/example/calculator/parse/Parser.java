package org.example.calculator.parse;

import org.example.calculator.operations.*;
import org.example.calculator.common.ErrorStack;
import org.example.calculator.exception.CalculatorException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-17
 * @time: 23:53
 * @desc:
 */
public class Parser {

    public void parseAndExecute(final String inputLine) {

        //用于解析命令
        List<ScanWord> cmdIn = parseInput(inputLine);

        for (ScanWord scanWord : cmdIn) {

            try {

                //解析操作符
                OperatorEnum operatorEnum = OperatorEnum.getOperator(scanWord.getOperation());
                switch (operatorEnum) {
                    case ADD:
                        new AddOperator(operatorEnum).parse(scanWord.getOperation()).process();
                        break;
                    case MINUS:
                        new MinusOperator(operatorEnum).parse(scanWord.getOperation()).process();
                        break;
                    case MULTIPLY:
                        new MultiplyOperator(operatorEnum).parse(scanWord.getOperation()).process();
                        break;
                    case DIVIDE:
                        new DivideOperator(operatorEnum).parse(scanWord.getOperation()).process();
                        break;
                    case SQRT:
                        new SqrtOperator(operatorEnum).parse(scanWord.getOperation()).process();
                        break;
                    case UNDO:
                        new UndoOperator(operatorEnum).parse(scanWord.getOperation()).process();
                        break;
                    case CLEAR:
                        new ClearOperator(operatorEnum).parse(scanWord.getOperation()).process();
                        break;
                    case NUM:
                        //解析操作数
                        new OperationNum().parse(scanWord.getOperation()).process();
                        break;
                    default:
                        break;
                }
            } catch (CalculatorException e) {
                parseException(e, scanWord);
            }
        }
    }

    /**
     * scan inputLine and get command word
     *
     * @param inputLine inputLine
     * @return {@link List<ScanWord>}
     */
    public List<ScanWord> parseInput(String inputLine) {
        List<ScanWord> scanWords = new ArrayList<>();
        for (int i = 0; i < inputLine.length();) {
            if (inputLine.charAt(i) != ' ') {
                int end = inputLine.indexOf(' ', i);
                end = end >= 0 ? end : inputLine.length();
                String word = inputLine.substring(i, end);
                ScanWord scanWord = new ScanWord(word, i + 1);
                scanWords.add(scanWord);
                i = end;
            } else {
                i++;
            }
        }
        return scanWords;
    }

    public void parseException(CalculatorException e, ScanWord scanWord) {

        //operator * (position: 15): insucient parameters
        String error = "operator "
                + scanWord.getOperation()
                + " (position: " + scanWord.getPosition() + "): "
                + e.getMessage();
        ErrorStack.push(error);
    }
}
