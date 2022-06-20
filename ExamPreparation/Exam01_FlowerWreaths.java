package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackLilies::push);


        ArrayDeque<Integer> queueRoses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int currentWreathSum = 0;
        int leftWreathSum = 0;
        int numberWreaths = 0;
        while (!stackLilies.isEmpty() && !queueRoses.isEmpty()) {

            int currentLily = stackLilies.peek();
            int currentRose = queueRoses.peek();

            if (currentLily + currentRose == 15) {
                stackLilies.pop();
                queueRoses.poll();
                numberWreaths++;
            } else if (currentLily + currentRose > 15) {
                while (currentLily >= 0) {
                    if (currentLily + currentRose == 15) {
                        stackLilies.pop();
                        queueRoses.poll();
                        numberWreaths++;
                        break;
                    } else if (currentLily + currentRose < 15) {
                        leftWreathSum = leftWreathSum + currentLily + queueRoses.poll();
                        stackLilies.pop();
                        break;
                    } else if (currentLily == 0 && currentRose == 15) {
                        stackLilies.pop();
                        queueRoses.poll();
                        numberWreaths++;
                        break;
                    } else if (currentLily == 0 && currentRose > 15) {
                        leftWreathSum = leftWreathSum + currentLily + queueRoses.poll();
                        stackLilies.pop();
                        break;
                    } else if (currentLily == 1 && currentRose >= 15) {
                        leftWreathSum = leftWreathSum + currentLily + queueRoses.poll();
                        stackLilies.pop();
                        break;
                    }
                    currentLily=currentLily-2;
                }
            } else if (currentLily + currentRose < 15) {
                leftWreathSum = leftWreathSum + stackLilies.pop() + queueRoses.poll();
            }
        }
        int numberWreathsFromLeftover = 0;
        numberWreathsFromLeftover = leftWreathSum / 15;
        numberWreaths = numberWreaths + numberWreathsFromLeftover;
        if (numberWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", numberWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - numberWreaths);
        }
    }
}
