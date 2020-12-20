package String.part3;

import org.testng.annotations.Test;
import part2.Matrix;

import static org.testng.Assert.*;

public class SomeStringsTest {
    private String string = "everything that is done is for the best ";

    @Test
    public void testEachCharacterSomeStrings() {
        SomeStrings.eachCharacterSomeStrings(string);
    }

    @Test
    public void testPrintBytesSomeStrings() {
        SomeStrings.printBytesSomeStrings(string);
        System.out.println();
    }

    @Test
    public void testCompareSomeStrings() {
        SomeStrings.compareSomeStrings();
    }

    @Test
    public void testPalindromeSomeStrings() {
        assertTrue(SomeStrings.palindromeSomeStrings(" Ежу хуже "));
        assertFalse(SomeStrings.palindromeSomeStrings("Ежик"));
    }

    @Test
    public void testIsEqualsCaseSomeArray() {
        assertTrue(SomeStrings.isEqualsCaseSomeArray("abc", "ABC"));
        assertFalse(SomeStrings.isEqualsCaseSomeArray(null, "ABC"));
        assertFalse(SomeStrings.isEqualsCaseSomeArray("abc", "abc"));
    }

    @Test
    public void testLastContainIndexInFirstHalfInSomeStrings() {
        assertEquals(SomeStrings.lastContainIndexInFirstHalfInSomeStrings("fgdabc", "abc"), 3, 0.001);
        assertEquals(SomeStrings.lastContainIndexInFirstHalfInSomeStrings("abcabdfgfabc", "ab"), 3, 0.001);
        assertEquals(SomeStrings.lastContainIndexInFirstHalfInSomeStrings("yiiiu", "ol"), -1, 0.001);
    }

    @Test
    public void testStringsStartsEndsWithInSomeArray() {
        assertEquals(SomeStrings.stringsStartsEndsWithInSomeArray(new String[]{"abcde", "abbde", "abbde", "abfde"}, "ab", "de"), 4, 0.001);
        assertEquals(SomeStrings.stringsStartsEndsWithInSomeArray(new String[]{"abcde", "abbde", "abbe", "abfe"}, "ab", "de"), 2, 0.001);
    }

    @Test
    public void testStringsStartsEndsInSomeStrings() {
        assertEquals(SomeStrings.stringsStartsEndsInSomeStrings(new String[]{"abbde, abbde, abfe"}, "ab", "de"), 1, 0.001);
        assertEquals(SomeStrings.stringsStartsEndsInSomeStrings(new String[]{"abcde", "abbde", "abbe", "abfe"}, "ab", "de"), 4, 0.001);

    }

    @Test
    public void testReplaceSomeArray() {
        assertEquals(SomeStrings.replaceSomeArray("ороророро", "оро", "ро"), "роррро");
        assertEquals(SomeStrings.replaceSomeArray("abcsde", "sd", "aa"), "abcaae");

    }
    @Test
    public void testFromToInSomeString() {
        assertEquals(SomeStrings.fromToInSomeString("abc", 0, 2), "ab");
        assertEquals(SomeStrings.fromToInSomeString("abcsgrha", 3, 4), "s");
        assertEquals(SomeStrings.fromToInSomeString("abc", -1, 100), "abc");
        assertEquals(SomeStrings.fromToInSomeString("abc", 3, 2), "");
    }
    /*
    @Test
    public void testPrintsObjectInSomeArray() {
        SomeStrings.printsObjectInSomeString  (new Person("Мария", "Бамбурова"));
        SomeStrings.printsObjectInSomeString (new Point(1, 2, 3));
        SomeStrings.printsObjectInSomeString (new NamedPoint(8, 1, 10, "First"));
        Matrix firstMatrix = new Matrix(2, 2);
        firstMatrix.setAt(1, 1, 10);
        firstMatrix.setAt(1, 2, 10);
        firstMatrix.setAt(2, 1, 10);
        firstMatrix.setAt(2, 2, 10);
        SomeStrings.printsObjectInSomeString (firstMatrix);
    }
    /
     */
    @Test
    public void testGetSingleInSomeStrings() {
        assertEquals(SomeStrings.getSingleInSomeStrings("hello i am 5 point")[0], "Hello");
        assertEquals(SomeStrings.getSingleInSomeStrings("hello i am 5 point")[1], "I");
        assertEquals(SomeStrings.getSingleInSomeStrings("hello i am 5 point")[2], "Am");
        assertEquals(SomeStrings.getSingleInSomeStrings("hello i am 5 point")[4], "Point");

    }

    @Test
    public void testBuildStringInSomeArray() {
        assertEquals(SomeStrings.buildStringInSomeArray(new String[]{"ab", "ac"}), "ab, ac");
        assertEquals(SomeStrings.buildStringInSomeArray(new String[]{"ab", "ac", ""}), "ab, ac, ");
        assertEquals(SomeStrings.buildStringInSomeArray(new String[]{}), "");
        assertEquals(SomeStrings.buildStringInSomeArray(new String[]{null, "ab"}), "null, ab");
    }
    @Test
    public void testBuildStringCharToIndexInSomeArray() {
        assertEquals(SomeStrings.buildStringCharToIndexInSomeArray("lifea"), "0i2a");
        assertEquals(SomeStrings.buildStringCharToIndexInSomeArray("qwertyuiop"), "0w2r4y6i8p");
        assertNull(SomeStrings.buildStringCharToIndexInSomeArray(null));
    }

 
    @Test
    public void testIntInSomeStrings() {
        assertEquals(SomeStrings.intInSomeStrings(10), "0 1 2 3 4 5 6 7 8 9");
        assertEquals(SomeStrings.intInSomeStrings(-1), "");
        System.out.println(SomeStrings.intInSomeStrings(10000));
    }
}
