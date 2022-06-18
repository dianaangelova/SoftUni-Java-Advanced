package ExamPreparation;

import java.util.*;

public class Exam01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] liquidsInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        for (String s : liquidsInput
        ) {
            queueLiquids.offer(Integer.valueOf(s));
        }

        int[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        for (int number : ingredientsInput) {
            stackIngredients.push(number);
        }

        Map<String, Integer> mapFood = new TreeMap<>();
        mapFood.put("Bread", 0);
        mapFood.put("Cake", 0);
        mapFood.put("Pastry", 0);
        mapFood.put("Fruit Pie", 0);
        
        while (!queueLiquids.isEmpty()) {
            int currentLiquid = queueLiquids.peek();
            int currentIngred = stackIngredients.peek();
            if (queueLiquids.peek() + stackIngredients.peek() == 25) {
                int currentNBread = mapFood.get("Bread");
                mapFood.put("Bread", currentNBread + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (queueLiquids.peek() + stackIngredients.peek() == 50) {
                int currentNCake = mapFood.get("Cake");
                mapFood.put("Cake", currentNCake + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (queueLiquids.peek() + stackIngredients.peek() == 75) {
                int currentNPastry = mapFood.get("Pastry");
                mapFood.put("Pastry", currentNPastry + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (queueLiquids.peek() + stackIngredients.peek() == 100) {
                int currentNFruitP = mapFood.get("Fruit Pie");
                mapFood.put("Fruit Pie", currentNFruitP + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else {
                queueLiquids.poll();
                int updatedIngredients = stackIngredients.pop() + 3;
                stackIngredients.push(updatedIngredients);
            }
        }
        for (String:
             ) {
            
        }
    }
}

