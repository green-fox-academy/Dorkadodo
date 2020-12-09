import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumTest {

    Sum sum;

    @Before
    public void addNumbers() {
        sum = new Sum();

    }

    @Test
    public void sumOfNumbers() {
        for (int i = 0; i < 6; i++) {
            sum.addNumber(i);
        }
        Integer expected = 15;
        Integer result = sum.sumOfNumbers();
        assertEquals(expected, result);
    }

    @Test
    public void sumOfEmptyList() {
        Integer expected = 0;
        Integer result = sum.sumOfNumbers();
        assertEquals(expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void sumOfListWithANull() {
        sum.addNumber(null);
        Integer expected = 0;
        Integer result = sum.sumOfNumbers();
    }

    @Test
    public void sumOfOneNumber() {
        sum.addNumber(5);
        Integer expected = 5;
        Integer result = sum.sumOfNumbers();
        assertEquals(expected, result);
    }

}