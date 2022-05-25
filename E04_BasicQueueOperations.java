package C1_StacksAndQueues;

import java.util.*;

public class E04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] command = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int countNumbers = command[0];
        int pollCount = command[1];
        int numberToSearch = command[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int number : numbers) {
            queue.offer(number);
        }
        for (int i = 0; i < pollCount; i++) {
            queue.poll();
        }

        if (queue.contains(numberToSearch)) {
            System.out.println("true");
        } else if (!queue.isEmpty()) {
            System.out.println(Collections.min(queue));
        } else {
            System.out.println("0");
        }

 //       System.out.println();
    }
}
