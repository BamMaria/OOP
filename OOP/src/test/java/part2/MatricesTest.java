package part2;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class MatricesTest {
    private Matrix first = new Matrix(new double[][]{{1, 2}, {3, 4}});
    private Matrix second = new Matrix(new double[][]{{1, 2, 3}, {3, 4, 5}, {6, 7, 8}});
    private Matrix third = new Matrix(new double[][]{{1, 2}, {2, 3}});
    private Matrix four = new Matrix(new double[][]{{1, 2}, {2, 3}, {5, 6}});
    @Test
    public void testSumMatrix() {
        assertNull(Matrices.sumMatrix(first, second));
        Matrix result = Matrices.sumMatrix(first, third);
        assert result != null;
        assertEquals(result.getAt(0, 0), 2, 0.001);
        assertEquals(result.getAt(1, 1), 7, 0.001);
        assertEquals(first.getAt(0, 0), 1, 0.001);
    }
    @Test
    public void testMultiplicationMatrix() {
        assertNull(Matrices.multiplicationMatrix(first, second));
        Matrix result = Matrices.multiplicationMatrix(first, third);
        assert result != null;
        assertEquals(result.getAt(0, 0), 5, 0.001);
        assertEquals(result.getAt(1, 1), 18, 0.001);
        assertEquals(first.getAt(0, 0), 1, 0.001);
        result = Matrices.multiplicationMatrix(second, four);
        assert result != null;
        assertEquals(result.getAt(0, 0), 1 + 2 * 2 + 3 * 5, 0.001);
    }
    @Test
    public void testMultiplicationMatrixAtNumber() {
        Matrix result = Matrices.multiplicationMatrixAtNumber(first);
        assertEquals(result.getAt(0, 0), first.getAt(0, 0) * 3, 0.001);
        assertEquals(result.getAt(1, 1), first.getAt(1, 1) * 3, 0.001);
    }
    @Test
    public void testMatrixDeterminant() {
        Matrix firstMatrix = new Matrix(2, 3);
        firstMatrix.setAt(0, 0, 1);
        firstMatrix.setAt(0, 1, 2);
        firstMatrix.setAt(1, 0, 3);
        firstMatrix.setAt(1, 1, 4);
        double secondResult = Matrices.matrixDeterminant(firstMatrix);
        assertEquals(secondResult, -2.0);
    }
}
