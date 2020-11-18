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

}