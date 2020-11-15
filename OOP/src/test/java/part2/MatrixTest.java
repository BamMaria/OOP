package part2;

import org.testng.annotations.Test;

import static org.testng.Assert .*;

    public class MatrixTest {
        private Matrix first = new Matrix();
        private Matrix second = new Matrix(2, 3);
        private Matrix third = new Matrix(new double[][]{{1, 2}, {3, 4}});

        @Test
        public void testGetRows() {
            assertEquals(first.getRows(), 0, 0.001);
            assertEquals(second.getRows(), 2, 0.001);
            assertEquals(third.getRows(), 2, 0.001);
        }

        @Test
        public void testGetColumns() {
            assertEquals(first.getColumns(), 0, 0.001);
            assertEquals(second.getColumns(), 3, 0.001);
            assertEquals(third.getColumns(), 2, 0.001);
        }

        @Test
        public void testGetAt() {
            assertEquals(third.getAt(0, 0), 1, 0.001);
            assertEquals(third.getAt(1, 1), 4, 0.001);
            assertEquals(third.getAt(0, 1), 2, 0.001);
            assertEquals(second.getAt(0, 0), 0, 0.001);
        }

        @Test
        public void testSetAt() {
            second.setAt(0, 0, 2);
            assertEquals(second.getAt(0, 0), 2, 0.001);
            second.setAt(0, 1, 33);
            assertEquals(second.getAt(0, 1), 33, 0.001);
        }
    }
