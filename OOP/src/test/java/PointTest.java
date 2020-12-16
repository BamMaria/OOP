import static org.testng.Assert.*;
import org.testng.annotations.Test;
public class PointTest {
    private Point firstPoint = new Point(1, 2, 3);
    private Point secondPoint = new Point(1.6, 3.1, 5.6);
    private Point thirdPoint = new Point(2.9, 3, 3.9);
    @Test
    void checkClass() {
        assertEquals(secondPoint.length(), Math.sqrt(1.6 * 1.6 + 3.1 * 3.1 + 5.6 * 5.6), 0.001);
        assertEquals(thirdPoint.length(), Math.sqrt(2.9 * 2.9 + 3 * 3 + 3.9 * 3.9), 0.001);
    }

    @Test
    void testToString() {
        assertEquals(firstPoint.toString(), "[1.0,2.0,3.0]");
        assertEquals(secondPoint.toString(), "[1.6,3.1,5.6]");
    }
}

