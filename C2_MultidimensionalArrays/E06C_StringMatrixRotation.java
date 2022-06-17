package C2_MultidimensionalArrays.Exercise;

import javax.security.sasl.SaslClient;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06C_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// NOT COMPLETED
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
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            int j = 0;
            for (String s : input) {
                if (cols >= s.length() && input.get(i).equals(s)) {
                    CharacterIterator it = new StringCharacterIterator(s);
                    while (it.current() != CharacterIterator.DONE) {
                        matrix[i][j] = String.valueOf(it.current());
                        it.next();
                        j++;
                    }
                }
            }
        }
    }
}
