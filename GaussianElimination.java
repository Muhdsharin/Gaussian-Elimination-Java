import java.util.Scanner;

class GaussianElimination {
    public static void main(String[] args) {
        Scanner numb = new Scanner(System.in);

        // User enters the total number of equations
        System.out.print("Enter the total number of equations: ");
        int eq = numb.nextInt();

        // User enters the number of variables
        System.out.print("Enter the number of variables: ");
        int var = numb.nextInt();

        // User enters the augmented matrix to be solved
        System.out.println("\nPlease enter the augmented matrix coefficients row-wise for:");
        printMatrix(eq, var);
    }

    // Read the coefficients of the augmented matrix from the user
    public static void printMatrix(int eq, int var) {
        Scanner index = new Scanner(System.in);

        // This line declares a 2D array named matrices to store the augmented matrix coefficients
        double matrices[][] = new double[eq][var + 1];

        for (int r = 0; r < eq; r++) {
            for (int c = 0; c <= var; c++) {
                System.out.print("matrix [" + (r + 1) + "][" + (c + 1) + "]: ");
                matrices[r][c] = index.nextDouble();
            }
        }

        System.out.println("\nOriginal matrix equation:");

        // Print original matrix
        printOri(matrices);

        // Solve using Gaussian Elimination
        printSolve(matrices);
    }

    // This method shows the original matrix and the matrix at each step
    public static void printOri(double matrices[][]) {
        for (double[] row : matrices) {
            for (double element : row) {
                if (element == -0) {
                    element = 0;
                }
                System.out.printf("%.2f ", element);
            }
            System.out.println();
        }
    }

    // This method calculates the augmented matrix using Gaussian elimination
    public static void printSolve(double matrices[][]) {
        int row = matrices.length;
        int col = matrices[0].length - 1;

        for (int a = 0; a < row; a++) {
            double zeroOut = matrices[a][a];

            // Make diagonal element 1
            for (int b = 0; b < col + 1; b++) {
                matrices[a][b] /= zeroOut;
            }

            // Eliminate other rows
            for (int d = 0; d < row; d++) {
                if (d != a) {
                    double factor = matrices[d][a];
                    for (int e = a; e < col + 1; e++) {
                        matrices[d][e] -= factor * matrices[a][e];
                    }
                }
            }

            System.out.println("\nStep " + (a + 1) + ":");
            printOri(matrices);
        }

        // Display final solution
        System.out.println("\nFinal Solution:");
        for (int z = 0; z < row; z++) {
            System.out.print("x" + (z + 1) + " = ");
            System.out.printf("%.2f%n", matrices[z][col]);
        }
    }
}