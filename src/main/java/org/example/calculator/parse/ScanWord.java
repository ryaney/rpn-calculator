package org.example.calculator.parse;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 11:43
 * @desc: 词法对象，存储词法元素以及元素位置
 */
public class ScanWord {
    //command
    private String operation;

    //position
    private Integer position;

    public ScanWord(String operation, Integer position) {
        this.operation = operation;
        this.position = position;
    }

    public String getOperation() {
        return operation;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "ScanWord{" +
                "operation='" + operation + '\'' +
                ", position=" + position +
                '}';
    }
}
