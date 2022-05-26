package C1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String s:numbers
             ) {
            stack.push(Integer.valueOf(s));
        }
        while (!stack.isEmpty()){
            System.out.printf(stack.pop() + " ");

        }
    }
}
