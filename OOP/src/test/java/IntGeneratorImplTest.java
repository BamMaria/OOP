import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IntGeneratorImplTest {
    IntGenerator testFunc = new IntGeneratorImpl();

    @Test
    public void testNextInt() {
        assertEquals(testFunc.nextInt(), 0, 0.0001);
        assertEquals(testFunc.nextInt(), 1, 0.0001);
        assertEquals(testFunc.nextInt(), 2, 0.0001);
        assertEquals(testFunc.nextInt(), 3, 0.0001);
    }


}