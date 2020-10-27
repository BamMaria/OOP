package part1.Operations;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdenticalOperationTest {

    IdenticalOperation testFunc = new IdenticalOperation();

    @Test
    public void testApply() {
        assertEquals(testFunc.apply(0), 0, 0.0001);
        assertEquals(testFunc.apply(8), 8, 0.0001);
        assertEquals(testFunc.apply(Double.NEGATIVE_INFINITY), Double.NEGATIVE_INFINITY, 0.0001);
        assertEquals(testFunc.apply(Double.POSITIVE_INFINITY), Double.POSITIVE_INFINITY, 0.0001);
        assertEquals(testFunc.apply(Double.NaN), Double.NaN, 0.0001);
    }

    @Test
    public void testApplyTriple() {
        assertEquals(testFunc.applyTriple(0), 0, 0.0001);
        assertEquals(testFunc.applyTriple(8), 8, 0.0001);
        assertEquals(testFunc.applyTriple(Double.NEGATIVE_INFINITY), Double.NEGATIVE_INFINITY, 0.0001);
        assertEquals(testFunc.applyTriple(Double.POSITIVE_INFINITY), Double.POSITIVE_INFINITY, 0.0001);
        assertEquals(testFunc.applyTriple(Double.NaN), Double.NaN, 0.0001);
    }
}