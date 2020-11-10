package part2;

public class SomeArray {
    public static int[] createSomeArray1(int length) {
        return new int[length];
    }

    public static int[] createSomeArray2(int length) {
        int[] someArray = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                someArray[i] = 2;
            } else {
                someArray[i] = 1;
            }
        }
        return someArray;
    }

    public static int[] createSomeArrayRisingOdd(int length) {
        int[] someArray = new int[length];
        for (int i = 1; i <= length; i++) {
            someArray[i - 1] = 2 * i - 1;
        }
        return someArray;
    }

    public static int[] createSomeArrayDownEven(int length) {
        int[] someArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            someArray[i] = 2 * (length - i);
        }
        return someArray;
    }

    public static int[] createSomeArrayFibonacci(int length) {
        int[] someArray = new int[length];
        int a = 0, b = 1, next;
        for (int i = 0; i < length; i++) {
            next = a + b;
            a = b;
            b = next;
            someArray[i] = next;
        }
        return someArray;
    }

    public static int[] createSomeArraySquareIndex(int length) {
        int[] someArray = new int[length];
        for (int i = 0; i < length; i++) {
            someArray[i] = i * i;
        }
        return someArray;
    }

    public static double[] createSomeArraySquareEquation(double a, double b, double c) {
        double v = b * b - 4 * a * c;
        if (v > 0) {
            double x1 = (-b + Math.sqrt(v)) / (2 * a);
            double x2 = (-b - Math.sqrt(v)) / (2 * a);
            double[] someArray = new double[2];
            someArray[0] = x1;
            someArray[1] = x2;
            return someArray;
        }
        if (v == 0) {
            double x = (-b) / (2 * a);
            double[] someArray = new double[1];
            someArray[0] = x;
            return someArray;
        }
        return new double[0];
    }

    public static int[] createSomeArrayNaturalNumber(int length) {
        int[] someArray = new int[length];
        int num = 1;
        for (int i = 0; i < length; i++) {
            if (num % 3 == 0) {
                num++;
            }
            someArray[i] = num;
            num++;
        }
        return someArray;
    }

    public static double[] createSomeArrayArithmeticProgression(int length, int firstElement, int difference) {
        double[] someArray = new double[length];
        someArray[0] = firstElement;
        for (int i = 1; i < length; i++) {
            someArray[i] = someArray[i - 1] + difference;
        }
        return someArray;
    }

    public static double[] createSomeArrayGeometricProgression(int length, int firstElement, int factor) {
        double[] someArray = new double[length];
        someArray[0] = firstElement;
        for (int i = 1; i < length; i++) {
            someArray[i] = someArray[i - 1] * factor;
        }
        return someArray;
    }

    public static double[] createSomeArrayOfDivers(int number) {

        int length = 1;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                length++;
            }
        }
        double[] someArray = new double[length];
        int k = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                someArray[k] = i;
                k++;
            }
        }
        someArray[length - 1] = number;
        return someArray;
    }

    public static double[] createSomeArrayPrimeNumbers(int number) {
        int dividers = 0, length = 0;
        for (int i = 1; i < number; i++) {
            for (int k = 1; k <= i; k++) {
                if (i % k == 0)
                    dividers++;
            }
            if (dividers <= 2) {
                length++;
            }
        }
        double[] someArray = new double[length];
        int m = 0;
        for (int i = 1; i < number; i++) {
            for (int k = 1; k <= i; k++) {
                if (i % k == 0)
                    dividers++;
            }
            if (dividers <= 2) {
                someArray[m] = i;
                m++;
            }
        }
        return someArray;
    }

    public static int[] createSomeArraySymmetric(int length) {
        int[] someArray = new int[length];
        for (int i = 1; i < length / 2 + 1; i++) {
            someArray[i - 1] = i;
            someArray[length - i] = i;
        }
        if (length % 2 == 1) {
            someArray[length / 2] = someArray[length / 2 - 1] + 1;
        }
        return someArray;
    }

    public static void oppositeSomeArray(double[] someArray) {
        for (int i = 0; i < someArray.length; i++) {
            someArray[i] = -someArray[i];
        }

    }

    public static boolean checkNumberInSomeArray(double[] someArray, int number) {
        for (double value : someArray) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkNullInSomeArray(Integer[] someArray) {
        for (Integer integer : someArray) {
            if (integer == null) {
                return true;
            }
        }
        return false;
    }
    public static int countEvenNumbersInSomeArray(int[] someArray) {
        int count = 0;
        for (int value : someArray) {
            if (value % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    public static Integer findMaxNumberInSomeArray(Integer[] someArray) {
        if (someArray.length == 0)
            return null;
        Integer max = someArray[0];
        for (int i = 1; i < someArray.length; i++) {
            if (someArray[i] > max) {
                max = someArray[i];
            }
        }
        return max;
    }
    public static double sumEvenIndexNumbersInSomeArray(double[] someArray) {
        int sum = 0;
        for (int i = 0; i < someArray.length; i += 2) {
            sum += someArray[i];
        }
        return sum;
    }
    public static boolean checkNumDevidersInSomeArray(int[] someArray) {
        int divideByFirst = 0, divideByLast = 0;
        for (int i = 0; i < someArray.length; i += 2) {
            if (someArray[i] % someArray[0] == 0)
                divideByFirst++;
            if (someArray[i] % someArray[someArray.length - 1] == 0)
                divideByLast++;
        }
        return divideByFirst > divideByLast;
    }
    public static int findMostPopularNumInSomeArray(int[] someArray) {
        int count = 0, maxCount = 0, currentNum, maxNum = 0;
        for (int value : someArray) {
            currentNum = value;
            for (int item : someArray) {
                if (currentNum == item)
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxNum = currentNum;
            }
            count = 0;
        }
        return maxNum;
    }
    static int equalsElementIndexInSomeArray(Number[] arr, Number found) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(found)) {
                return i;
            }
        }
        return -1;
    }
    public static void swapFirstMaxAndMinNumInSomeArray(int[] someArray) {
        int maxNumber = someArray[0], minNumber = someArray[0], maxIndex = 0, minIndex = 0;
        for (int i = 1; i < someArray.length; i++) {
            if (someArray[i] > maxNumber) {
                maxNumber = someArray[i];
                maxIndex = i;
            }
            if (someArray[i] < minNumber) {
                minNumber = someArray[i];
                minIndex = i;
            }
        }
        someArray[maxIndex] = minNumber;
        someArray[minIndex] = maxNumber;
    }
    public static void bitwiseNegationInSomeArray(int[] someArray) {
        for (int i = 0; i < someArray.length; i++) {
            someArray[i] = ~someArray[i];
        }
    }
    public static int[] negateSomeArray(int[] someArray) {
        int[] newSomeArray = new int[someArray.length];
        for (int i = 0; i < someArray.length; i++) {
            newSomeArray[i] = ~someArray[i];
        }
        return newSomeArray;
    }

}
