package org.example.calculator;

import org.example.calculator.common.CmdStack;
import org.example.calculator.common.UndoStack;
import org.example.calculator.operations.AbstractOperator;

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

        // Break each line entered into a command and a parameter string
        try {
            Starter starter = new Starter();
            starter.start(new String[]{"5","2","+"});

//            while (true) {
//                // Input command from user
//                System.out.print("\n>>  ");
//                String cmdInput = starter.scanner.nextLine();
//                String[] ci = cmdInput.toLowerCase().trim().split(" ");
//
//                // Call the parser to send the command to the correct function to execute
//                CommandParser.Parse(cmdInput, cmdInputCmd, cmdInputParam);
//
//                // Clear input parameters before we start again
//                cmdInputCmd = "";
//                cmdInputParam = "";
//
//            } // End While Loop
//
//            // Close the scanner
//            scanner.close();
//
//            // Save the items in the memory slots to the preferences system
//            StackMemory.SaveMemSlots();
//
//            // Save the primary and secondary stacks to the preferences system
//            StackManagement.SaveStack(calcStack, "1");
//            StackManagement.SaveStack(calcStack2, "2");
//
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void start(String[] args) {
        if (args == null) {
            return;
        }

        //parameter check

        Parser parser = new Parser();
        List<String> cmdIn = Arrays.asList(args);;
        parser.parseAndExecute(cmdIn);
        System.out.println(CmdStack.getCmdStack());
        System.out.println(UndoStack.getUndoStack());

    }
}
