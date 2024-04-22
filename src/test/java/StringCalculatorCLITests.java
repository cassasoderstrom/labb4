import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorCLITests {
    @Test
    public void testEmptyNumberString() {

        String input = "scalc ''\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        assertTrue(outputStream.toString().contains("0"+System.lineSeparator()+"Exiting..."+System.lineSeparator()));
    }

    @Test
    public void testEmptyNumberString2() {
        String input = "scalc ''\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertTrue(outputStream.toString().contains("0"+System.lineSeparator()+"Exiting..."+System.lineSeparator()));

    }
    @Test
    public void testWelcomeMessage() {
        String input = "scalc ''\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertTrue(outputStream.toString().contains("Welcome"));

    }

    @Test
    public void testResultMessage() {
        String input = "scalc '1,2,3'\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertTrue(outputStream.toString().contains("The result is 6"+System.lineSeparator()));

    }

    @Test
    public void testMultipleLines() {
        String input = "scalc '1,2,3'\nscalc '1,2,3,4'\n\nscalc '1,2,3,4,5'\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertTrue(outputStream.toString().contains("The result is 6"+System.lineSeparator()));
        assertTrue(outputStream.toString().contains("The result is 10"+System.lineSeparator()));
        assertTrue(outputStream.toString().contains("The result is 15"+System.lineSeparator()));

    }

    @Test
    public void testOwnSimpleSeparator() {
        String input = "scalc '//;\n1;2;3'\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertTrue(outputStream.toString().contains("The result is 6"+System.lineSeparator()));

    }

    @Test
    public void testOwnComplexSeparator() {
        String input = "scalc '//[%%%][***]\n1%%%2***3'\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertTrue(outputStream.toString().contains("The result is 6"+System.lineSeparator()));


    }
}