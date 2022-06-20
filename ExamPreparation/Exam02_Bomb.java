package ExamPreparation;

import java.util.Scanner;

public class Exam02_Bomb {
    public static int bombFound = 0;
    public static boolean isEndHit = false;
    public static int rowS = 0;
    public static int colS = 0;
    public static int countBombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String commands = scanner.nextLine();
        String[] commandsArray = commands.split(",");

        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String[] arrayInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                char c = arrayInput[j].charAt(0);
                matrix[i][j] = c;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 's') {
                    rowS = i;
                    colS = j;
                }
                if (matrix[i][j] == 'B') {
                    countBombs++;
                }
            }
        }

        for (int i = 0; i < commandsArray.length; i++) {
            String currentCommand = commandsArray[i];

            if (currentCommand.equals("up"))
                moveSapper(matrix, rowS - 1, colS);

            else if (currentCommand.equals("down"))
                moveSapper(matrix, rowS + 1, colS);

            else if (currentCommand.equals("left"))
                moveSapper(matrix, rowS, colS - 1);

            else if (currentCommand.equals("right"))
                moveSapper(matrix, rowS, colS + 1);

            if (isEndHit) {
                System.out.printf("END! %d bombs left on the field%n", countBombs - bombFound);
                break;
            }
            if (countBombs==bombFound){
                break;
            }
        }

        if (countBombs == bombFound && isEndHit == false) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isEndHit == false) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countBombs - bombFound, rowS, colS);
        }
    }

    private static boolean moveSapper(char[][] matrix, int nextRow, int nextCol) {
        if (isInBounds(matrix, nextRow, nextCol)) {
            if (matrix[nextRow][nextCol] == 'B') {
                bombFound++;
                System.out.println("You found a bomb!");
            } else if (matrix[nextRow][nextCol] == 'e') {
                isEndHit = true;
            }

            matrix[rowS][colS] = '+';
            matrix[nextRow][nextCol] = 's';
            rowS = nextRow;
            colS = nextCol;

        }
        return isEndHit;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {

        // true if in bounds
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
