package edu.wit.cs.comp1000.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import edu.wit.cs.comp1000.PA01a;

public class PA01aTestCase {
    private void runTest(String input, String expectedOutput) {
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));

        String[] args = {};
        PA01a.main(args);

        String output = outContent.toString().trim();  // Trim to remove any extra whitespace
        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void testMainMethod() {
        runTest("1\n2\n3\n", "Enter number of yards: Enter number of feet: Enter number of inches: Total number of inches: 63");
        runTest("0\n0\n0\n", "Enter number of yards: Enter number of feet: Enter number of inches: Total number of inches: 0");
        runTest("2\n0\n0\n", "Enter number of yards: Enter number of feet: Enter number of inches: Total number of inches: 72");
        runTest("0\n5\n0\n", "Enter number of yards: Enter number of feet: Enter number of inches: Total number of inches: 60");
        runTest("0\n0\n100\n", "Enter number of yards: Enter number of feet: Enter number of inches: Total number of inches: 100");
    }

}
