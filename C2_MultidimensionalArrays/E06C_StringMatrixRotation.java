package C2_MultidimensionalArrays.Exercise;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06C_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        command = command.replace("Rotate(", "");
        command = command.replace(")", "");
        int degree = Integer.parseInt(command);
        List<String> input = new ArrayList<>();
        String word = scanner.nextLine();
        int maxCharsWord = 0;
        while (!word.equals("END")) {
            input.add(word);
            if (word.length() > maxCharsWord) {
                maxCharsWord = word.length();
            }
            word = scanner.nextLine();
        }
        int rows = input.size();
        int cols = maxCharsWord;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentWord = input.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';

                }
            }
        }

        int angleOfRotation = degree % 360;

        printMatrix(matrix, rows, cols, angleOfRotation);

    }

    private static void printMatrix(char[][] matrix, int rows, int cols, int angleOfRotation) {
        int newRows;
        int newCols;
        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows-1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}