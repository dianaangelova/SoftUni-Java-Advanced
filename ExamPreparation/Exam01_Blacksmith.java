package ExamPreparation;

import javax.xml.validation.Validator;
import java.util.*;
import java.util.stream.Collectors;

public class Exam01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Steel – queue     carbon stack
        ArrayDeque<Integer> queueSteel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackCarbon = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackCarbon::push);
        Map<Integer, Integer> mapValues = new HashMap<>();
        mapValues.put(70, 0);
        mapValues.put(80, 0);
        mapValues.put(90, 0);
        mapValues.put(110, 0);

        while (!queueSteel.isEmpty() && !stackCarbon.isEmpty()) {
            int currentSum = queueSteel.peek() + stackCarbon.peek();
            if (currentSum == 70) {
                int value70 = mapValues.get(70);
                mapValues.put(70, value70 + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else if (currentSum == 80) {
                int value80 = mapValues.get(80);
                mapValues.put(80, value80 + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else if (currentSum == 90) {
                int value90 = mapValues.get(90);
                mapValues.put(90, value90 + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else if (currentSum == 110) {
                int value110 = mapValues.get(110);
                mapValues.put(110, value110 + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else {
                queueSteel.poll();
                int carbon = stackCarbon.peek() + 5;
                stackCarbon.pop();
                stackCarbon.push(carbon);
            }
        }
        boolean anyNonNullValues = mapValues.entrySet().stream().anyMatch(e -> e.getValue() > 0);

        if (!anyNonNullValues) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            int countValues = 0;
            for (var entry : mapValues.entrySet()) {
                countValues = countValues + entry.getValue();
            }
            System.out.printf("You have forged %d swords.%n", countValues);
        }

        String remainingSteel = queueSteel.isEmpty() ? "none" : queueSteel.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Steel left: " + remainingSteel);

        String remainingCarbon = stackCarbon.isEmpty() ? "none" : stackCarbon.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Carbon left: " + remainingCarbon);

        Map<String, Integer> mapNames = new TreeMap<>();

        mapNames.put("Gladius", mapValues.get(70));
        mapNames.put("Shamshir", mapValues.get(80));
        mapNames.put("Katana", mapValues.get(90));
        mapNames.put("Sabre", mapValues.get(110));

        for (var entry : mapNames.entrySet()) {

            if (entry.getValue() != 0) {
                System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue()));
            }

        }
    }
}
