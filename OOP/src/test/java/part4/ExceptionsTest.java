package part4;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExceptionsTest {
    ExceptionsClass exceptionsClass = new ExceptionsClass();

    @Test
    public void testStringMassif() {
        assertEquals(exceptionsClass.StringMassif(new String[]{"Hello", "World"}, 2), new char[]{'l', 'r'});
        assertEquals(exceptionsClass.StringMassif(new String[]{"облако", "йод", "груша"}, 2), new char[]{'л', 'д', 'у'});

        assertThrows(NullPointerException.class, () -> {
            exceptionsClass.StringMassif(new String[3], 1);
        });
    }

    @Test
    public void testStringsParts() {
        assertEquals(exceptionsClass.StringsParts(new String[]{"Привет", "облако"}, 1, 2), 'л');

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            exceptionsClass.StringsParts(new String[]{"hey", "hay"}, 2, 1);
        });
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            exceptionsClass.StringsParts(new String[]{"hey", "hay"}, 1, 3);
        });
    }

    @Test
    public void testDivisionString() {
        assertEquals(exceptionsClass.divisionString("25", "5"), 5);

        assertThrows(NumberFormatException.class, () -> {
            exceptionsClass.divisionString("53", "");
        });
        assertThrows(NumberFormatException.class, () -> {
            exceptionsClass.divisionString("uidr", "5");
        });
    }
}
