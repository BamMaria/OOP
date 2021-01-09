package part_5;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LocationTest {

    @Test
    public void testEquals() {
        Location location_1 = new Location();
        Location location_2 = new Location();
        location_1.setId(1);
        location_2.setId(2);
        Location location_3 = location_1;
        assertNotEquals(location_2, location_1);
        assertEquals(location_1, location_3);
    }
}