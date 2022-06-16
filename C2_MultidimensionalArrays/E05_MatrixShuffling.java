package C2_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class E05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] arrayInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arrayInput[j];
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] arrayCommand = command.split("\\s+");
            boolean isInvalid = false;
            if (arrayCommand.length != 5 || !arrayCommand[0].equals("swap") || Integer.parseInt(arrayCommand[1]) > rows
                    || Integer.parseInt(arrayCommand[1]) < 0 || Integer.parseInt(arrayCommand[2]) > cols || Integer.parseInt(arrayCommand[2]) < 0
                    || Integer.parseInt(arrayCommand[3]) > rows || Integer.parseInt(arrayCommand[3]) < 0
                    || Integer.parseInt(arrayCommand[4]) > cols || Integer.parseInt(arrayCommand[4]) < 0) {
                System.out.println("Invalid input!");
                isInvalid = true;
            } else {
                int rowFirst = Integer.parseInt(arrayCommand[1]);
                int colFirst = Integer.parseInt(arrayCommand[2]);
                int rowSecond = Integer.parseInt(arrayCommand[3]);
                int colSecond = Integer.parseInt(arrayCommand[4]);
                String temp = matrix[rowFirst][colFirst];
                matrix[rowFirst][colFirst] = matrix[rowSecond][colSecond];
                matrix[rowSecond][colSecond] = temp;

            }
            if (!isInvalid) {
                for (String[] arr : matrix) {
                    for (String n : arr) {
                        System.out.print(n + " ");
                    }
                    System.out.println();
                }
            }

            command = scanner.nextLine();
        }


    }
}
