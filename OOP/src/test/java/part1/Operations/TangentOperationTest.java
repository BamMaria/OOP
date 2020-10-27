package part1.Operations;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TangentOperationTest {

    TangentOperation testFunc = new TangentOperation();

    @Test
    public void testApply() {
        assertEquals(testFunc.apply(0), 0, 0.0001);
        assertEquals(testFunc.apply(16), Math.tan(16), 0.0001);
        assertEquals(testFunc.apply(Double.NEGATIVE_INFINITY), Double.NaN, 0.0001);
        assertEquals(testFunc.apply(Double.POSITIVE_INFINITY), Double.NaN, 0.0001);
        assertEquals(testFunc.apply(Double.NaN), Double.NaN, 0.0001);
    }

    @Test
    public void testApplyTriple() {
        assertEquals(testFunc.apply(0), 0, 0.0001);
        assertEquals(testFunc.apply(16), Math.tan(16), 0.0001);
        assertEquals(testFunc.apply(Double.NEGATIVE_INFINITY), Double.NaN, 0.0001);
        assertEquals(testFunc.apply(Double.POSITIVE_INFINITY), Double.NaN, 0.0001);
        assertEquals(testFunc.apply(Double.NaN), Double.NaN, 0.0001);
    }
}