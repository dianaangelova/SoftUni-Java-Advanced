package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam02_MouseAndCheese2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // matrix size n
        int n = Integer.parseInt(scanner.nextLine());

        //fill the matrix
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.next().toCharArray();
        }

        //read commands and make changes
        String command = scanner.next();
        int countCheese = 0;

        int rowM = 0;
        int colM = 0;
        boolean mouseFound = false;
        for (int i = 0; i < n && mouseFound == false; i++) {
            for (int j = 0; j < n && mouseFound == false; j++) {
                if (matrix[i][j] == 'M') {
                    rowM = i;
                    colM = j;
                    mouseFound = true;
                }
            }
        }

        while (!command.equals("end")) {

            if (command.equals("up")) {
                if (rowM - 1 < 0) {
                    matrix[rowM][colM] = '-';
                    System.out.println("Where is the mouse?");
                    break;
                }
                if (matrix[rowM - 1][colM] == 'c') {
                    countCheese++;
                } else if (matrix[rowM - 1][colM] == 'B') {
                    if (matrix[rowM - 2][colM] == 'c') {
                        countCheese++;
                    }
                    matrix[rowM][colM] = '-';
                    matrix[rowM - 1][colM] = 'M';
                    rowM = rowM - 1;
                }

                matrix[rowM][colM] = '-';
                matrix[rowM - 1][colM] = 'M';
                rowM = rowM - 1;

            } else if (command.equals("down")) {
                if (rowM + 1 >= n) {
                    matrix[rowM][colM] = '-';
                    System.out.println("Where is the mouse?");
                    break;
                }
                if (matrix[rowM + 1][colM] == 'c') {
                    countCheese++;
                } else if (matrix[rowM + 1][colM] == 'B') {
                    if (matrix[rowM + 2][colM] == 'c') {
                        countCheese++;
                    }
                    matrix[rowM][colM] = '-';
                    matrix[rowM + 1][colM] = 'M';
                    rowM = rowM + 1;
                }

                matrix[rowM][colM] = '-';
                matrix[rowM + 1][colM] = 'M';
                rowM = rowM + 1;

            } else if (command.equals("left")) {
                if (colM - 1 < 0) {
                    matrix[rowM][colM] = '-';
                    System.out.println("Where is the mouse?");
                    break;
                }

                if (matrix[rowM][colM - 1] == 'c') {
                    countCheese++;
                } else if (matrix[rowM][colM - 1] == 'B') {
                    if (matrix[rowM][colM - 2] == 'c') {
                        countCheese++;
                    }
                    matrix[rowM][colM] = '-';
                    matrix[rowM][colM - 1] = 'M';
                    colM = colM - 1;
                }
                matrix[rowM][colM] = '-';
                matrix[rowM][colM - 1] = 'M';
                colM = colM - 1;
            } else if (command.equals("right")) {
                if (colM + 1 >= n) {
                    matrix[rowM][colM] = '-';
                    System.out.println("Where is the mouse?");
                    break;
                }
                if (matrix[rowM][colM + 1] == 'c') {
                    countCheese++;
                } else if (matrix[rowM][colM + 1] == 'B') {
                    if (matrix[rowM][colM + 2] == 'c') {
                        countCheese++;
                    }
                    matrix[rowM][colM] = '-';
                    matrix[rowM][colM + 1] = 'M';
                    colM = colM + 1;
                }
                matrix[rowM][colM] = '-';
                matrix[rowM][colM + 1] = 'M';
                colM = colM + 1;
            }

            command = scanner.next();
        }
        if (countCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - countCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", countCheese);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

}