package edu.wit.cs.comp1000.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import edu.wit.cs.comp1000.PA01a;
import edu.wit.cs.comp1000.PA01b;

public class PA01bTestCase {
    
    private void runTest(String input, String expectedOutput) {
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));

        String[] args = {};
        PA01b.main(args);

        String output = outContent.toString().trim();  // Trim to remove any extra whitespace at the beginning and end
        output = output.replaceAll("\\s+", " ");  // Replace sequences of whitespace with a single space

        expectedOutput = expectedOutput.trim(); // Do the same normalization for expected output if needed
        expectedOutput = expectedOutput.replaceAll("\\s+", " ");

        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void testMainMethod() {
        runTest("50\n", "Enter number of inches: Yards: 1\nFeet: 1\nInches: 2");
        runTest("0\n", "Enter number of inches: Yards: 0\nFeet: 0\nInches: 0");
        runTest("12\n", "Enter number of inches: Yards: 0\nFeet: 1\nInches: 0");
        runTest("36\n", "Enter number of inches: Yards: 1\nFeet: 0\nInches: 0");
        runTest("100\n", "Enter number of inches: Yards: 2\nFeet: 2\nInches: 4");
    }
}
