package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Exam01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //vowels - гласни
        String[] vowelsInput = scanner.nextLine().split("\\s+");

        ArrayDeque<String> queueVowels = new ArrayDeque<>();
        for (String s : vowelsInput) {
            queueVowels.offer(s);
        }

        //consonants - съгласни

        String[] consonantsInput = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stackConsonants = new ArrayDeque<>();
        for (String s : consonantsInput) {
            stackConsonants.push(s);
        }

        Map<String, Set<String>> mapFood = new LinkedHashMap<>();
        mapFood.put("pear", new HashSet<>());
        mapFood.put("flour", new HashSet<>());
        mapFood.put("pork", new HashSet<>());
        mapFood.put("olive", new HashSet<>());

        while (!stackConsonants.isEmpty()) {
            String vow = queueVowels.pop();
            String cons = stackConsonants.poll();
            for (var entry : mapFood.entrySet()) {
                if (entry.getKey().contains(vow)) {
                    entry.getValue().add(vow);
                }
                if (entry.getKey().contains(cons)) {
                    entry.getValue().add(cons);
                }
            }
            queueVowels.offer(vow);
        }

        List<String> foundWord = new ArrayList<>();

        for (var entry : mapFood.entrySet()) {
            if (entry.getKey().length() == entry.getValue().size()) {
                foundWord.add(entry.getKey());
            }
        }
        System.out.println("Words found: "+foundWord.size());
        for (String s : foundWord) {
            System.out.println(s);
        }
    }
}
