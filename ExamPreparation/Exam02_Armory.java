package ExamPreparation;

import java.util.Scanner;

public class Exam02_Armory {
    public static int rowA = 0;
    public static int colA = 0;
    public static int rowM1 = 0;
    public static int rowM2 = 0;
    public static int colM1 = 0;
    public static int colM2 = 0;
    public static int coinsSum = 0;
    public static boolean isInBounds = true;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String[] arrayInput = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                char c = arrayInput[j].charAt(0);
                matrix[i][j] = c;
            }
        }

        boolean firstMirrorFound = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'A') {
                    rowA = i;
                    colA = j;
                }
                if (matrix[i][j] == 'M') {
                    if (!firstMirrorFound) {
                        rowM1 = i;
                        colM1 = j;
                        firstMirrorFound = true;
                    } else {
                        rowM2 = i;
                        colM2 = j;
                    }
                }
            }
        }


        while (coinsSum <= 65) {
            String commands = scanner.nextLine();

            if (commands.equals("up"))
                moveArmory(matrix, rowA - 1, colA);

            else if (commands.equals("down"))
                moveArmory(matrix, rowA + 1, colA);

            else if (commands.equals("left"))
                moveArmory(matrix, rowA, colA - 1);

            else if (commands.equals("right"))
                moveArmory(matrix, rowA, colA + 1);

            if (!isInBounds) {
                System.out.printf("I do not need more swords!%n");
                break;
            }
            if (coinsSum >= 65) {
                System.out.printf("Very nice swords, I will come back for more!%n");
                break;
            }
        }
        System.out.printf("The king paid %d gold coins.%n", coinsSum);

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean moveArmory(char[][] matrix, int nextRow, int nextCol) {

        if (isInBounds(matrix, nextRow, nextCol)) {

            if (Character.isDigit(matrix[nextRow][nextCol])) {
                coinsSum = coinsSum + Integer.parseInt(String.valueOf(matrix[nextRow][nextCol]));

            } else if (matrix[nextRow][nextCol] == 'M') {

                if (nextRow == rowM1 && nextCol == colM1) {
                    matrix[nextRow][nextCol] = '-';
                    nextRow = rowM2;
                    nextCol = colM2;

                } else if (nextRow == rowM2 && nextCol == colM2) {
                    matrix[nextRow][nextCol] = '-';
                    nextRow = rowM1;
                    nextCol = colM1;
                }
            }

            matrix[rowA][colA] = '-';
            matrix[nextRow][nextCol] = 'A';
            rowA = nextRow;
            colA = nextCol;

        } else {
            isInBounds = false;
            matrix[rowA][colA] = '-';
        }
        return isInBounds;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {

        // true if in bounds
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
