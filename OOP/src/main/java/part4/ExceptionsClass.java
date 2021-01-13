package part4;

public class ExceptionsClass {
    public char[] StringMassif(String[] strings, int index) {
        char[] chars = new char[strings.length];
        for (int i = 0; i < strings.length; i++) {
            chars[i] = strings[i].charAt(index);
        }
        return chars;
    }
    public char StringsParts(String[] strings, int m, int n) {
        return strings[m].charAt(n);
    }
}
