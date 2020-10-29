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
}
