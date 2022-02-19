package org.example.calculator;

import org.example.calculator.common.CmdStack;
import org.example.calculator.common.ErrorStack;
import org.example.calculator.parse.Parser;
import org.junit.Assert;
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
        parser.parseAndExecute("5 2");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(2));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(5));
        CmdStack.clear();
    }

    @Test
    public void example2() {
        Parser parser = new Parser();
        parser.parseAndExecute("2 sqrt");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(Math.sqrt(2)));

        parser.parseAndExecute("clear 9 sqrt");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(3));
        CmdStack.clear();
    }

    @Test
    public void example3() {
        Parser parser = new Parser();
        parser.parseAndExecute("5 2 -");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(3));

        parser.parseAndExecute("3 -");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(0));

        parser.parseAndExecute("clear");
        Assert.assertTrue(CmdStack.empty());
        CmdStack.printCmdStack();
        CmdStack.clear();
    }

    @Test
    public void example4() {
        Parser parser = new Parser();
        parser.parseAndExecute("5 4 3 2");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(2));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(3));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(4));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(5));

        parser.parseAndExecute("5 4 3 2");
        parser.parseAndExecute("undo undo *");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(20));

        parser.parseAndExecute("5 *");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(100));

        parser.parseAndExecute("undo");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(5));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(20));

        CmdStack.clear();
    }

    @Test
    public void example5() {
        Parser parser = new Parser();
        parser.parseAndExecute("7 12 2 /");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(6));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(7));

        parser.parseAndExecute("7 12 2 /");
        parser.parseAndExecute("*");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(42));

        parser.parseAndExecute("4 /");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(10.5));

        CmdStack.clear();
    }

    @Test
    public void example6() {
        Parser parser = new Parser();
        parser.parseAndExecute("1 2 3 4 5");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(5));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(4));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(3));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(2));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(1));

        parser.parseAndExecute("1 2 3 4 5");
        parser.parseAndExecute("*");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(20));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(3));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(2));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(1));

        parser.parseAndExecute("1 2 3 4 5");
        parser.parseAndExecute("*");
        parser.parseAndExecute("clear 3 4 -");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(-1));

        CmdStack.clear();
    }

    @Test
    public void example7() {
        Parser parser = new Parser();
        parser.parseAndExecute("1 2 3 4 5");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(5));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(4));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(3));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(2));
        Assert.assertEquals(CmdStack.pop().getOperationNum(), new Double(1));

        parser.parseAndExecute("1 2 3 4 5");
        parser.parseAndExecute("* * * *");
        CmdStack.printCmdStack();
        Assert.assertEquals(CmdStack.peek().getOperationNum(), new Double(120));

        CmdStack.clear();
    }

    @Test
    public void example8() {
        Parser parser = new Parser();
        parser.parseAndExecute("1 2 3 * 5 + * * 6 5");
        ErrorStack.printErrorStack();
        Assert.assertEquals(ErrorStack.getErrorStack().pop(), "operator * (position: 15): insufficient parameters");

        CmdStack.printCmdStack();
        CmdStack.clear();
    }
}
