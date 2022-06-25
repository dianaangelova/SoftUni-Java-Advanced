package Exam_25June2022;

import java.util.Scanner;

public class Exam02_StickyFingers {
    public static int houseFound = 0;
    public static boolean isCaught = false;
    public static int rowD = 0;
    public static int colD = 0;
    public static int allMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commandsArray = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];


        for (int i = 0; i < size; i++) {
            String[] arrayInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                char c = arrayInput[j].charAt(0);
                matrix[i][j] = c;
                if (c == 'D') {
                    rowD = i;
                    colD = j;
                }
            }
        }

        for (int i = 0; i < commandsArray.length; i++) {
            String currentCommand = commandsArray[i];

            if (currentCommand.equals("up"))
                moveDillinger(matrix, rowD - 1, colD);

            else if (currentCommand.equals("down"))
                moveDillinger(matrix, rowD + 1, colD);

            else if (currentCommand.equals("left"))
                moveDillinger(matrix, rowD, colD - 1);

            else if (currentCommand.equals("right"))
                moveDillinger(matrix, rowD, colD + 1);

            if (isCaught) {
                break;
            }
        }
        if (isCaught == false) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", allMoney);
        }

        print2dArray(matrix);
    }


    private static boolean moveDillinger(char[][] matrix, int nextRow, int nextCol) {
        if (isInBounds(matrix, nextRow, nextCol)) {
            if (matrix[nextRow][nextCol] == '$') {
                houseFound++;
                int money = nextRow * nextCol;
                allMoney = allMoney + money;
                System.out.printf("You successfully stole %d$.%n", money);
                matrix[rowD][colD] = '+';
                matrix[nextRow][nextCol] = 'D';
                rowD = nextRow;
                colD = nextCol;
            } else if (matrix[nextRow][nextCol] == 'P') {
                matrix[rowD][colD] = '+';
                matrix[nextRow][nextCol] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.%n", allMoney);
                isCaught = true;
            } else {
                matrix[rowD][colD] = '+';
                matrix[nextRow][nextCol] = 'D';
                rowD = nextRow;
                colD = nextCol;
            }
        } else {
            System.out.println("You cannot leave the town, there is police outside!");
        }
        return isCaught;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void print2dArray(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.printf(c + " ");
            }
            System.out.println();
        }
    }

}
