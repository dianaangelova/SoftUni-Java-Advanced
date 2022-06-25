package Exam_25June2022;

import java.util.*;
import java.util.stream.Collectors;

public class Exam01_ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));

        ArrayDeque<Double> queueMilk = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> stackCacao = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(stackCacao::push);

        long percentage = -1;

        Map<String, Integer> map = new TreeMap<>();
        map.put("Milk Chocolate", 0);
        map.put("Dark Chocolate", 0);
        map.put("Baking Chocolate", 0);

        while (stackCacao.size() != 0) {

            Double currentMilk = queueMilk.poll();
            Double currentCacao = stackCacao.poll();

            percentage = Math.round((currentCacao / (currentMilk + currentCacao)) * 100);

            if (percentage == 30) {
                map.put("Milk Chocolate", map.get("Milk Chocolate") + 1);
            } else if (percentage == 50) {
                map.put("Dark Chocolate", map.get("Dark Chocolate") + 1);
            } else if (percentage == 100) {
                map.put("Baking Chocolate", map.get("Baking Chocolate") + 1);
            } else {
                queueMilk.offer(currentMilk + 10);
            }
        }
        int count = 0;

        for (var entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                count++;
            }
        }


        if (count == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue()>0){
                System.out.println(String.format(" # %s --> %d", entry.getKey(), entry.getValue()));
            }
        }

    }
}
