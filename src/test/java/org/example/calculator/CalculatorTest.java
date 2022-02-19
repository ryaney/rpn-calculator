package org.example.calculator;

import org.example.calculator.parse.Parser;
import org.junit.Test;

/**
 * @author: ryan_scy@126.com
 * @date: 2022-02-19
 * @time: 20:17
 * @desc:
 */
public class CalculatorTest {

    @Test
    public void example1() {
        Parser parser = new Parser();
        parser.parseInput("5 2");
    }
}
