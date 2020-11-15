package part2;


    class Matrices {
        static Matrix sumMatrix(Matrix first, Matrix second) {
            int rows = first.getRows();
            int columns = first.getColumns();
            if (rows == second.getRows() && columns == second.getColumns()) {
                Matrix result = new Matrix(rows, columns);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        result.setAt(i, j, first.getAt(i, j) + second.getAt(i, j));
                    }
                }
                return result;
            }
            return null;
        }

        static Matrix multiplicationMatrix(Matrix first, Matrix second) {
            int rows = first.getRows();
            int columns = first.getColumns();
            if (columns == second.getRows()) {
                Matrix result = new Matrix(rows, second.getColumns());
                double value = 0;
                for (int i = 0; i < rows; i++) {
                    for (int k = 0; k < second.getColumns(); k++) {
                        for (int j = 0; j < columns; j++) {
                            value = value + first.getAt(i, j) * second.getAt(j, k);
                        }
                        result.setAt(i, k, value);
                        value = 0;
                    }
                }
                return result;
            }
            return null;
        }

        static Matrix multiplicationMatrixAtNumber(Matrix matrix) {
            Matrix result = new Matrix(matrix.getRows(), matrix.getColumns());
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    result.setAt(i, j, matrix.getAt(i, j) * (double) 3);
                }
            }
            return result;
        }

        private static Matrix getMinor(Matrix matrix, int column) {
            int minorLength = matrix.getColumns() - 1;
            Matrix minor = new Matrix(minorLength, minorLength);
            int a = 0;
            int b;
            for (int i = 0; i <= minorLength; i++) {
                b = 0;
                for (int j = 0; j <= minorLength; j++) {
                    if (i == 0) {
                        a = 1;
                    } else {
                        if (j == column) {
                            b = 1;
                        } else {
                            minor.setAt(i - a, j - b, matrix.getAt(i, j));
                        }
                    }
                }
            }
            return minor;
        }

        static double matrixDeterminant(Matrix matrix) {
            if (matrix.getRows() == (matrix).getColumns()) {
                return Double.parseDouble(null);
            }
            double Det = 0;
            if (matrix.getRows() == 2) {
                return matrix.getAt(0, 0) * matrix.getAt(1, 1) - matrix.getAt(0, 1) * matrix.getAt(1, 0);
            } else {
                int k;
                for (int j = 0; j < matrix.getColumns(); j++) {
                    k = j % 2 == 0 ? 1 : -1;
                    Det += k * matrix.getAt(0, j) * matrixDeterminant(getMinor(matrix, j));
                }
            }
            return Det;
        }
    }



