package C1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E06_RecursiveFibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        if (n < 2) {
            System.out.println(1);
            return;
        }

        ArrayDeque<Long> stack = new ArrayDeque<>();

        stack.push(0l);
        stack.push(1l);
        for (int i = 0; i < n; i++) {
            long num2 = stack.pop();
            long num1 = stack.pop();
            stack.push(num2);
            stack.push(num2+num1);
        }
        System.out.println(stack.pop());
    }
}
