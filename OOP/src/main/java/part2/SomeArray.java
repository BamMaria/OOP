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
}
