package String.part3;

public class SomeStrings {
    static public void eachCharacterSomeStrings(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
    }

    static public void printBytesSomeStrings(String string) {
        var bytes = string.getBytes();
        for (byte byt : bytes) {
            System.out.println(byt);
        }
    }

    static void compareSomeStrings() {
        String string = "А за окном зима... ";
        String stringOne = new String(string);
        System.out.println(string == stringOne);
        System.out.println(string.equals(stringOne));
    }

    static boolean palindromeSomeStrings(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean isEqualsCaseSomeArray(String stringOne, String stringTwo) {
        return stringOne != null && stringTwo != null && !(stringOne.equals(stringTwo)) && stringOne.equalsIgnoreCase(stringTwo);
    }

    static int lastContainIndexInFirstHalfInSomeStrings(String stringOne, String stringTwo) {
        if (stringOne.contains(stringTwo)) {
            return stringOne.lastIndexOf(stringTwo, stringOne.length() / 2);
        } else if (stringTwo.contains(stringOne)) {
            return stringTwo.lastIndexOf(stringOne, stringTwo.length() / 2);
        } else {
            return -1;
        }
    }
    static int stringsStartsEndsWithInSomeArray(String[] strings, String prefix, String suffix) {
        int k = 0;
        for (String string : strings) {
            if (string.startsWith(prefix) && string.endsWith(suffix)) {
                k++;
            }
        }
        return k;
    }
    static int stringsStartsEndsInSomeStrings(String[] strings, String prefix, String suffix) {
        int k = 0;
        for (String string : strings) {
            if (string.trim().startsWith(prefix) && string.trim().endsWith(suffix)) ;
            k++;
        }
        return k;
    }


}