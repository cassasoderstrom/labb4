import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        Assertions.assertEquals(0, calculator.add(""));
    }
    @Test
    public void testOneNumber() {
        Assertions.assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        Assertions.assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testManyNumbers() {
        Assertions.assertEquals(40, calculator.add("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"));
    }

    @Test
    public void testNewLineSeparator() {
        Assertions.assertEquals(5, calculator.add("1\n1,1\n1,1"));
    }

    @Test
    public void testOwnSeparator() {
        Assertions.assertEquals(15, calculator.add("//;\n1;2;3;4;5"));
        Assertions.assertEquals(15, calculator.add("//#\n1#2#3#4#5"));
        Assertions.assertEquals(15, calculator.add("//!\n1!2!3!4!5"));
    }

    @Test
    public void testNegativeNumber() {
        Assertions.assertThrows(RuntimeException.class, () ->  calculator.add("1\n1,-1\n1,1"));
    }
}
