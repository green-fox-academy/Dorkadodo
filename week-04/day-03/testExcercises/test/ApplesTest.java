import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplesTest {

    Apples apple;
    @Test
    public void getApple() {
        apple = new Apples();
        String expected = "apple";
        String result = apple.getApple();
        assertEquals(expected, result);
    }


}