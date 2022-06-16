package C2_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class E03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int i = 0; i < n; i++) {
            String[] arrayInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(arrayInput[j]);
                if (i == j) {
                    sumFirstDiagonal += matrix[i][j];
                }
            }
        }
        int i = 0;

        for (int j = n - 1; j >= 0; j--) {
            while (i < n) {
                int element = matrix[i][j];
                sumSecondDiagonal += element;
                break;
            }
            i++;
        }
        System.out.println(Math.abs(sumFirstDiagonal-sumSecondDiagonal));

    }
}

