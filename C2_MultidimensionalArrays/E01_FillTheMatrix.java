package C2_MultidimensionalArrays;

import java.lang.reflect.Array;
import java.util.Scanner;

public class E01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        if (pattern.equals("A")) {
            int[][] matrixA = fillMatrixA(n);
            printMatrix(matrixA);

        } else {
            int[][] matrixB = fillMatrixB(n);
            printMatrix(matrixB);

        }
    }

    private static int[][] fillMatrixA(int n) {

        int[][] matrix = new int[n][n];
        int element = 0;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = element + 1;
                element++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixB(int n) {

        int[][] matrix = new int[n][n];
        int element = 0;
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = element + 1;
                    element++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = element + 1;
                    element++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
