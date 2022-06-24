package ExamPreparation;

import java.util.Scanner;

public class Exam02_PawnWars_70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        int rowW = -1;
        int colW = -1;
        int rowB = -1;
        int colB = -1;
        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 8; j++) {
                char c = line.charAt(j);
                matrix[i][j] = c;
                if (c == 'w') {
                    rowW = i;
                    colW = j;
                }
                if (c == 'b') {
                    rowB = i;
                    colB = j;
                }
            }
        }
        String winner = "";
        int rowWin = -1;
        int colWin = -1;
        boolean promoted = false;
        boolean captured = false;

        while ((rowW != 0 && rowB != 7) && (!captured) && (!promoted)) {

            if (matrix[rowW - 1][colW - 1] == 'b') {
                matrix[rowW - 1][colW - 1] = 'w';
                rowWin = rowW - 1;
                colWin = colW - 1;
                winner = "White";
                captured = true;
                break;
            } else if (matrix[rowW - 1][colW + 1] == 'b') {
                matrix[rowW - 1][colW + 1] = 'w';
                rowWin = rowW - 1;
                colWin = colW + 1;
                winner = "White";
                captured = true;
                break;
            } else {
                matrix[rowW][colW] = '-';
                matrix[rowW - 1][colW] = 'w';
                rowW = rowW - 1;
            }

            if (rowW == 0) {
                winner = "White";
                rowWin = 0;
                colWin = colW;
                promoted = true;
                break;
            }

            if (matrix[rowB + 1][colB - 1] == 'w') {
                matrix[rowB + 1][colB - 1] = 'b';
                winner = "Black";
                rowWin = rowB + 1;
                colWin = colB - 1;
                captured = true;
                break;
            } else if (matrix[rowB + 1][colB + 1] == 'w') {
                matrix[rowB + 1][colB + 1] = 'b';
                winner = "Black";
                rowWin = rowB + 1;
                colWin = colB + 1;
                captured = true;
                break;
            } else {
                matrix[rowB][colB] = '-';
                matrix[rowB + 1][colB] = 'b';
                rowB = rowB + 1;
            }

            if (rowB == 7) {
                winner = "Black";
                promoted = true;
                rowWin = 7;
                colWin = colB;
                break;
            }
        }

        String[][] matrixChess = new String[8][8];
        String valueWin = "";

        for (int i = 8; i > 0; i--) {
            for (int j = 97; j <= 104; j++) {
                char c = (char) j;
                char a = Character.forDigit(i, 10);
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                sb.append(a);
                matrixChess[8 - i][j - 97] = sb.toString();
                if (8 - i == rowWin && j - 97 == colWin) {
                    valueWin = sb.toString();
                }
            }
        }

        if (promoted == true) {
            System.out.println("Game over! " + winner + " pawn is promoted to a queen at " + valueWin + ".");
        } else {
            System.out.println("Game over! " + winner + " capture on " + valueWin + ".");
        }
    }
}

