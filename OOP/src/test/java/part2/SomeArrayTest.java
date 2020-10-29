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
    @Test
    public void testCreateSomeArray2() {
        int[] array = SomeArray.createSomeArray2(lengthArrayTest);
        assertEquals(array[0], 2, 0.001);
        for (int i = 0; i < lengthArrayTest; i++) {
            if (i == 0 || i == lengthArrayTest - 1) {
                assertEquals(array[i], 2, 0.001);
            } else {
                assertEquals(array[i], 1, 0.001);
            }
        }
    }
    @Test
    public void testCreateSomeArrayRisingOdd() {
        int[] array = SomeArray.createSomeArrayRisingOdd(lengthArrayTest);
        for (int i = 1; i <= lengthArrayTest; i++) {
            assertEquals(array[i - 1], i * 2 - 1, 0.001);
        }
    }
}