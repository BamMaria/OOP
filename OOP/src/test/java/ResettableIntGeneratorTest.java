import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ResettableIntGeneratorTest {
    IntGenerator testFunc = new ResettableIntGenerator();

    @Test
    public void testNextInt() {
        assertEquals(testFunc.nextInt(), 0, 0.0001);
        assertEquals(testFunc.nextInt(), 1, 0.0001);
        assertEquals(testFunc.nextInt(), 2, 0.0001);
    }

    @Test
    public void testReset() {
        ((Resettable) testFunc).reset();
        assertEquals(testFunc.nextInt(), 0, 0.0001);
        assertEquals(testFunc.nextInt(), 1, 0.0001);
        ((Resettable) testFunc).reset();
        assertEquals(testFunc.nextInt(), 0, 0.0001);
        assertEquals(testFunc.nextInt(), 1, 0.0001);
    }
}