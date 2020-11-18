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
}