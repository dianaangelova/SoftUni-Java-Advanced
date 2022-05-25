package C1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsNumber; i++) {
            int[] command = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (command[0] == 1) {

                stack.push(command[1]);

            } else if (command[0] == 2) {
                stack.pop();

            } else if (command[0] == 3) {
                System.out.println(stack.stream().max(Integer::compare).get());
            }

        }

    }
}
