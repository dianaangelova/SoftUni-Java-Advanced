package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Exam01_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueIngredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter((i -> i != 0))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackFreshness = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackFreshness::push);

        Map<Integer, Integer> mapCocktails = new LinkedHashMap<>();
        mapCocktails.put(300, 0);
        mapCocktails.put(400, 0);
        mapCocktails.put(150, 0);
        mapCocktails.put(250, 0);


        while (!stackFreshness.isEmpty() && !queueIngredients.isEmpty()) {
            int currentIngredient = queueIngredients.peek();
            int currentFreshness = stackFreshness.peek();
            if (currentIngredient * currentFreshness == 150) {
                int current150 = mapCocktails.get(150);
                mapCocktails.put(150, current150 + 1);
                queueIngredients.poll();
                stackFreshness.pop();
            } else if (currentIngredient * currentFreshness == 250) {
                int current250 = mapCocktails.get(250);
                mapCocktails.put(250, current250 + 1);
                queueIngredients.poll();
                stackFreshness.pop();
            } else if (currentIngredient * currentFreshness == 300) {
                int current300 = mapCocktails.get(300);
                mapCocktails.put(300, current300 + 1);
                queueIngredients.poll();
                stackFreshness.pop();
            } else if (currentIngredient * currentFreshness == 400) {
                int current400 = mapCocktails.get(400);
                mapCocktails.put(400, current400 + 1);
                queueIngredients.poll();
                stackFreshness.pop();
            } else {
                stackFreshness.pop();
                int increasedIngredient = currentIngredient + 5;
                queueIngredients.poll();
                queueIngredients.offer(increasedIngredient);
            }
        }

        boolean allCocktails = true;
        for (int i : mapCocktails.values()) {
            if (i == 0) {
                allCocktails = false;
                break;
            }
        }

        if (allCocktails) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sumLeftIngredients = 0;
        while (!queueIngredients.isEmpty()) {
            sumLeftIngredients = sumLeftIngredients + queueIngredients.poll();
        }
        if (sumLeftIngredients != 0) {
            System.out.printf("Ingredients left: %d%n", sumLeftIngredients);
        }



        String cocktailName = "";
        for (var entry : mapCocktails.entrySet()) {

            if (entry.getValue() != 0) {
                if (entry.getKey() == 150) {
                    cocktailName = "Pear Sour";
                } else if (entry.getKey() == 250) {
                    cocktailName = "The Harvest";
                }else if (entry.getKey() == 300) {
                    cocktailName = "Apple Hinny";
                }else if (entry.getKey() == 400) {
                    cocktailName = "High Fashion";
                }
                System.out.println(String.format("# %s --> %d", cocktailName, entry.getValue()));
            }

        }

    }
}
