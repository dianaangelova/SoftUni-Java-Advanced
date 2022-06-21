package ExamPreparation;

import java.util.Scanner;

public class Exam02_Armory {
    public static int rowA = 0;
    public static int colA = 0;
    public static int rowM1 = 0;
    public static int rowM2 = 0;
    public static int colM1 = 0;
    public static int colM2 = 0;

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
//test
        
    }
}
