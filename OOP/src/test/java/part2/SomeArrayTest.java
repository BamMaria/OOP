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

    @Test
    public void testCreateSomeArrayDownEven() {
        int[] array = SomeArray.createSomeArrayDownEven(lengthArrayTest);
        for (int i = lengthArrayTest - 1; i >= 0; i--) {
            assertEquals(array[i], 2 * (lengthArrayTest - i), 0.001);
        }
    }

    @Test
    public void testCreateSomeArrayFibonacci() {
        int[] array = SomeArray.createSomeArrayFibonacci(lengthArrayTest);
        assertEquals(array[lengthArrayTest - 1], 89, 0.001);
    }

    @Test
    public void testCreateSomeArraySquareIndex() {
        int[] array = SomeArray.createSomeArraySquareIndex(lengthArrayTest);
        assertEquals(array[lengthArrayTest - 1], 81, 0.001);
    }

    @Test
    public void testCreateSomeArraySquareEquation() {
        double[] array = SomeArray.createSomeArraySquareEquation(3, -11, 10);
        assertEquals(array[0], 2, 0.001);
        assertEquals(array[1], 5. / 3, 0.001);
        double[] arrayOne = SomeArray.createSomeArraySquareEquation(2, -8, 8);
        assertEquals(arrayOne[0], 2, 0.001);
    }

    @Test
    public void testCreateSomeArrayNaturalNumber() {
        int[] array = SomeArray.createSomeArrayNaturalNumber(lengthArrayTest);
        for (int i = 0; i < lengthArrayTest; i++) {
            assertTrue(array[i] % 3 != 0);
        }
    }

    @Test
    public void createSomeArrayArithmeticProgression() {
        double[] array = SomeArray.createSomeArrayArithmeticProgression(lengthArrayTest, 3, 13);
        for (int i = 1; i < lengthArrayTest; i++) {
            assertEquals(array[i] - array[i - 1], 13, 0.001);
        }
    }

    @Test
    public void testCreateSomeArrayGeometricProgression() {
        double[] array = SomeArray.createSomeArrayGeometricProgression(lengthArrayTest, 3, 13);
        for (int i = 1; i < lengthArrayTest; i++) {
            assertEquals(array[i] / array[i - 1], 13, 0.001);
        }
    }

    @Test
    public void testCreateSomeArrayOfDivers() {
        int number = 15;
        double[] array = SomeArray.createSomeArrayOfDivers(15);
        for (double v : array) {
            assertEquals(number % v, 0, 0.001);
        }
    }

    @Test
    public void testCreateSomeArrayPrimeNumbers() {
        var array = SomeArray.createSomeArrayPrimeNumbers(21);
        for (double v : array) {
            assertEquals(SomeArray.createSomeArrayOfDivers((int) v).length, 1, 0.0001);
            System.out.println(v);
        }
    }

    @Test
    public void testCreateSomeArraySymmetric() {
        int[] array = SomeArray.createSomeArraySymmetric(lengthArrayTest);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], array[lengthArrayTest - i - 1], 0.001);
        }
    }

    @Test
    public void testOppositeSomeArray() {
        double[] array = new double[]{1., 3., 4., 5};
        SomeArray.oppositeSomeArray(array);
        assertEquals(array[0], -1, 0.001);
        assertEquals(array[1], -3, 0.001);
        assertEquals(array[2], -4, 0.001);
        assertEquals(array[3], -5, 0.001);

    }
    @Test
    public void testCheckNumberInSomeArray() {
        double[] array = new double[]{1., 3., 4., 5};
        assertFalse(SomeArray.checkNumberInSomeArray(array, 9));
        assertTrue(SomeArray.checkNumberInSomeArray(array, 3));
        assertFalse(SomeArray.checkNumberInSomeArray(array, 50));
    }
    @Test
    public void testCheckNullInSomeArray()
    {
        assertTrue(SomeArray.checkNullInSomeArray(new Integer[]{1, 2, 3, 4, null}));
        assertFalse(SomeArray.checkNullInSomeArray(new Integer[]{1, 2, 3, 4}));
    }
    @Test
    public void testCountEvenNumbersInSomeArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(SomeArray.countEvenNumbersInSomeArray(array), 4, 0.00001);
        int[] arrayTwo = new int[]{5, 13, 51, 11, 5, 1, 9, 3, 61};
        assertEquals(SomeArray.countEvenNumbersInSomeArray(arrayTwo), 0, 0.00001);
    }
    @Test
    public void testFindMaxNumberInSomeArray() {
        assertEquals(SomeArray.findMaxNumberInSomeArray(new Integer[]{1, 2, 3, 4, 5}), (Integer) 5);
        assertNull(SomeArray.findMaxNumberInSomeArray(new Integer[]{}));
        assertEquals(SomeArray.findMaxNumberInSomeArray(new Integer[]{12, 35, 5, 2}), (Integer) 35);
    }
    @Test
    public void testSumEvenIndexNumbersInSomeArray() {
        double[] array = new double[]{2., 4., 5.};
        assertEquals(SomeArray.sumEvenIndexNumbersInSomeArray(array), 7., 0.00001);
        double[] arrayTwo= new double[]{2., 10., 10., 10., 5., 18., 1., 3.};
        assertEquals(SomeArray.sumEvenIndexNumbersInSomeArray(arrayTwo), 18., 0.00001);
    }
    @Test
    public void testCheckNumDevidersInSomeArray() {
        assertTrue(SomeArray.checkNumDevidersInSomeArray(new int[]{2, 4, 6, 3}));
        assertFalse(SomeArray.checkNumDevidersInSomeArray(new int[]{2, 4, 6, 9, 9, 3}));
    }
    @Test
    public void testFindMostPopularNumInSomeArray() {
        assertEquals(SomeArray.findMostPopularNumInSomeArray(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6}), 2);
        assertEquals(SomeArray.findMostPopularNumInSomeArray(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 1}), 1);
    }
    @Test
    public void equalsElementIndexInSomeArray() {
        var arr = new Number[]{1, 2, 3, 4, 5};
        for (int i = 1; i < 6; i++) {
            assertEquals(SomeArray.equalsElementIndexInSomeArray(arr, i), i - 1, 0.001);
        }
        assertEquals(SomeArray.equalsElementIndexInSomeArray(arr, 0), -1, 0.001);
    }
    @Test
    public void testSwapFirstMaxAndMinNumInSomeArray() {
        int[] array = new int[]{1, 2, 3, 4, 7, 3};
        SomeArray.swapFirstMaxAndMinNumInSomeArray(array);
        assertEquals(array[0], 7, 0.001);
        assertEquals(array[4], 1, 0.001);
        array = new int[]{1, 5, 3, 4, 5, 4, 3, 2, 0};
        SomeArray.swapFirstMaxAndMinNumInSomeArray(array);
        assertEquals(array[1], 0, 0.001);
        assertEquals(array[8], 5, 0.001);
    }
}

