package part1.Operations;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrtOperationTest {
    SqrtOperation testFunc = new SqrtOperation();

    @Test
    public void testApply() {
        assertEquals(testFunc.apply(0), 0, 0.0001);
        assertEquals(testFunc.apply(16), Math.sqrt(16), 0.0001);
        assertEquals(testFunc.apply(Double.NEGATIVE_INFINITY), Double.NaN, 0.0001);
        assertEquals(testFunc.apply(Double.POSITIVE_INFINITY), Double.POSITIVE_INFINITY, 0.0001);
        assertEquals(testFunc.apply(Double.NaN), Double.NaN, 0.0001);
    }

    @Test
    public void testApplyTriple() {
        assertEquals(testFunc.apply(0), 0, 0.0001);
        assertEquals(testFunc.apply(16), Math.sqrt(16), 0.0001);
        assertEquals(testFunc.apply(Double.NEGATIVE_INFINITY), Double.NaN, 0.0001);
        assertEquals(testFunc.apply(Double.POSITIVE_INFINITY), Double.POSITIVE_INFINITY, 0.0001);
        assertEquals(testFunc.apply(Double.NaN), Double.NaN, 0.0001);
    }
}