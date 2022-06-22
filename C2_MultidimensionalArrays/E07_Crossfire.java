package C2_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class E07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeList = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(sizeList[0]);
        int col = Integer.parseInt(sizeList[1]);

        int[][] matrix = new int[row][col];
        int nextInt = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nextInt = nextInt + 1;
                matrix[i][j] = nextInt;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {

            String[] command = input.split("\\s+");
            int rowDestroy = Integer.parseInt(command[0]);
            int colDestroy = Integer.parseInt(command[1]);
            int radiusDestroy = Integer.parseInt(command[2]);

            if (isInBounds(matrix, rowDestroy, colDestroy)) {
                matrix[rowDestroy][colDestroy] = (0);
            }

            for (int i = 1; i <= radiusDestroy; i++) {
                if (isInBounds(matrix, rowDestroy - i, colDestroy)) {
                    matrix[rowDestroy - i][colDestroy] = (0);
                }
                if (isInBounds(matrix, rowDestroy + i, colDestroy)) {
                    matrix[rowDestroy + i][colDestroy] = (0);
                }
                if (isInBounds(matrix, rowDestroy, colDestroy - i)) {
                    matrix[rowDestroy][colDestroy - i] = (0);
                }
                if (isInBounds(matrix, rowDestroy, colDestroy + i)) {
                    matrix[rowDestroy][colDestroy + i] = (0);
                }
            }

            input = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        // true if in bounds
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
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
