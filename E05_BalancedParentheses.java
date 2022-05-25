package C1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {

            Character character = input.charAt(i);

            if (stack.isEmpty()) {
                if ((character.equals(')') || character.equals(']') || character.equals('}'))) {
                    isValid = false;
                } else {
                    stack.push(character);
                }
            } else {
                if ((character.equals('(') || character.equals('[') || character.equals('{'))) {
                    stack.push(character);
                } else if (character.equals(')')) {
                    if (stack.peek().equals('(')) {
                        stack.pop();
                    } else isValid = false;
                    break;
                } else if (character.equals(']')) {
                    if (stack.peek().equals('[')) {
                        stack.pop();
                    } else isValid = false;
                    break;
                } else if (character.equals('}')) {
                    if (stack.peek().equals('{')) {
                        stack.pop();
                    } else isValid = false;
                    break;
                }

            }
        }

        if (isValid == true && stack.isEmpty()) {
            System.out.println("YES");

        } else {
            System.out.println("NO");
        }
    }
}
