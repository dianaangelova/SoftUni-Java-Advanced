package C2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        String[][] matrixA = readMatrix(scanner, rows, columns);
        String[][] matrixB = readMatrix(scanner, rows, columns);

        String[][] matrixC = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (matrixA[row][col].equals(matrixB[row][col])) {
                    matrixC[row][col] = matrixA[row][col];
                } else matrixC[row][col] = "*";
            }
        }
        printMatrix(matrixC);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] s : matrix) {
            for (String ch : s) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scanner, Integer rows, Integer columns) {

        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {

            String arr[] = scanner.nextLine().split(" ");

            matrix[row] = arr;

        }
        return matrix;
    }


}
