package C1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> indexOpen = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(') {
                indexOpen.push(i);

            } else if (currentChar == ')') {
                int lastOpenIndex = indexOpen.pop();
                String matchingBr = input.substring(lastOpenIndex, i+1);
                System.out.println(matchingBr);
            }
        }
    }
}
