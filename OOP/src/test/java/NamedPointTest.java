import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NamedPointTest {
    NamedPoint firstPoint = new NamedPoint();
    NamedPoint secondPoint = new NamedPoint(1, 2, 3, "One");
    NamedPoint thirdPoint = new NamedPoint(1, 2, 3);
    @Test
    public void testSetName() {
        assertEquals(firstPoint.getName(), "Origin");
        assertEquals(secondPoint.getName(), "One");
        assertNull(thirdPoint.getName());
    }
    @Test
    public void testGetName() {
        firstPoint.setName("Two");
        assertEquals(firstPoint.getName(), "Two");
        secondPoint.setName(null);
        assertNull(secondPoint.getName());
        thirdPoint.setName("Five");
        assertEquals(thirdPoint.getName(), "Five");
    }

    @Test
    public void testReset()
    {
        firstPoint.reset();
        assertEquals(firstPoint.getName(), "Absent");
        thirdPoint.reset();
        assertEquals(thirdPoint.getName(), "Absent");
    }

}
