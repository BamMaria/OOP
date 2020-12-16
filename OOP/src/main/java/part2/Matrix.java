package part2;
import java.util.StringJoiner;
public class Matrix {
    private double[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix() {
        rows = 0;
        columns = 0;
        matrix = new double[rows][columns];
    }

    public Matrix(double[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        this.matrix = matrix;
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new double[rows][columns];
    }

    int getRows() {
        return rows;
    }

    int getColumns() {
        return columns;
    }

    double getAt(int n, int m) {
        return matrix[n - 1][m - 1];
    }

    void setAt(int n, int m, double value) {
        matrix[n - 1][m - 1] = value;
    }

    @Override
    public String toString() {
        StringBuilder auxiliaryString = new StringBuilder();
        StringBuilder stringOutput = new StringBuilder();
        for (double[] rows : matrix) {
            for (double a : rows) {
                auxiliaryString.append(a + ",");
            }
            auxiliaryString.replace(auxiliaryString.length() - 1, auxiliaryString.length(), "");
            stringOutput.append(auxiliaryString.toString() + ";\n");
            auxiliaryString = new StringBuilder("");
        }
        return stringOutput.toString();
    }
}