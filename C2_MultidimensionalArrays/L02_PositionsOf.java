package C2_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class L02_PositionsOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] inputMatrix = readMatrix(scanner);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<String> outputLines = new ArrayList<>();


        for (int row = 0; row < inputMatrix.length; row++) {
            for (int col = 0; col < inputMatrix[row].length; col++) {

                int element = inputMatrix[row][col];

                if (element == number) {
                    outputLines.add(row + " " + col);
                }
            }
        }

        if (outputLines.isEmpty()) {
            System.out.println("not found");
        } else {
            for (String s : outputLines) {
                System.out.println(s);
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            int arr[] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;

        }
        return matrix;
    }
}
