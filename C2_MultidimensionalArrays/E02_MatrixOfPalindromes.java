package C2_MultidimensionalArrays.Exercise;

import javax.security.sasl.SaslClient;
import java.util.Arrays;
import java.util.Scanner;

public class E02_MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] matrix = getMatrix(r, c);
        printMatrix(matrix);
    }

    private static String[][] getMatrix(int r, int c) {

        String[][] matrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char first = (char) ('a' + i);
                char middle = (char) ('a' + i + j);

                matrix[i][j] = String.valueOf(first) + middle + first;

            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("[\\[\\],]", ""));
    }

}

