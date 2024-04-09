public class multMatriciesTrad {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int n = 256;
        int[][] A = createMatrix(n);

        System.out.println("Matrix A:");

        printMatrix(A);

        int[][] B = createMatrix(n);

        System.out.println("Matrix B:");

        printMatrix(B);

        int[][] C = multiply(A, B);

        System.out.println("Matrix C:");

        printMatrix(C);
    }

    static int[][] createMatrix(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        return matrix;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    static int[][] multiplyDivideAndConquer(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];

            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            int[][] C11 = new int[n / 2][n / 2];
            int[][] C12 = new int[n / 2][n / 2];
            int[][] C21 = new int[n / 2][n / 2];
            int[][] C22 = new int[n / 2][n / 2];

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    A11[i][j] = A[i][j];
                    A12[i][j] = A[i][j + n / 2];
                    A21[i][j] = A[i + n / 2][j];
                    A22[i][j] = A[i + n / 2][j + n / 2];

                    B11[i][j] = B[i][j];
                    B12[i][j] = B[i][j + n / 2];
                    B21[i][j] = B[i + n / 2][j];
                    B22[i][j] = B[i + n / 2][j + n / 2];

                    
                }
            }
        }
    }


    static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    

}
