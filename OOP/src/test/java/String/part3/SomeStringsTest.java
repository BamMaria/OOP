package String.part3;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SomeStringsTest {
    private String string = "everything that is done is for the best ";
    @Test
    public void testEachCharacterSomeStrings() {
        SomeStrings.eachCharacterSomeStrings(string);
    }
} 