package part2;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SomeArrayTest {

    private int lengthArrayTest = 10;

    @Test
    public void testCreateSomeArray1() {
        int[] array = SomeArray.createSomeArray1(lengthArrayTest);
        assertEquals(array.length, lengthArrayTest, 0.001);
    }
}