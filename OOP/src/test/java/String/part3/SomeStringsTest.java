package String.part3;

import org.testng.annotations.Test;

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
}