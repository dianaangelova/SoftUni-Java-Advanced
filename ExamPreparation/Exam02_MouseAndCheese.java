package ExamPreparation;

import java.util.Scanner;

public class Exam02_MouseAndCheese {

    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {


            // Move mouse will be called with the correct mutators in each case the mutators are defining the
            // movement direction
            // UP { -1, 0}
            // DOWN { 1, 0}
            // LEFT { 0, -1}
            // RIGHT { 0, 1}
            if (command.equals("up")) {
                moveMouse(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveMouse(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveMouse(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveMouse(matrix, 0, 1);
            }

            if (!mouseIsInField) {
                break;
            }

            command = scanner.nextLine();
        }

        if (!mouseIsInField) {
            System.out.println("Where is the mouse?");
        }

        if (eatenCheese >= 5) {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " +
                    (5 - eatenCheese) + " cheeses more.");
        }

        print2dArray(matrix);
    }

    /**
     *
     * @param matrix char[][] the mouse field
     * @param rowMutator int mutator that will be added to the current row of the mouse
     * @param colMutator int mutator that will be added to the current col of the mouse
     */
    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isBonusHit = false;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        if (matrix[nextRow][nextCol] == 'c') {
            eatenCheese++;
        } else if (matrix[nextRow][nextCol] == 'B') {
            isBonusHit = true;
        }

        matrix[row][col] = '-';
        matrix[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        if (isBonusHit) {
            // Call this same method with the same mutators again if bonus is hit
            moveMouse(matrix, rowMutator, colMutator);
        }
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void print2dArray(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}