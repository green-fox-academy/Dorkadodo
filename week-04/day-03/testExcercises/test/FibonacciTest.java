import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    Fibonacci fib;

    @Test
    public void fibonacciHappyCase() {
        fib = new Fibonacci();
        assertEquals(5, fib.fibonacci(6, 0));
    }

    @Test
    public void fibonacciOneAsInput() {
        fib = new Fibonacci();
        assertEquals(0, fib.fibonacci(1, 0));
    }

    @Test
    public void fibonacciTwoAsInput() {
        fib = new Fibonacci();
        assertEquals(1, fib.fibonacci(2, 0));
    }
}