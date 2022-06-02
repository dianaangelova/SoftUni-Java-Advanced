package C3_SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputText = scanner.nextLine().split("-");

        Map<String, String> map = new HashMap<>();

        while (!inputText[0].equals("search")) {

            map.putIfAbsent(inputText[0], inputText[1]);
            map.put(inputText[0], inputText[1]);
            inputText = scanner.nextLine().split("-");
        }

        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")) {
            if (map.containsKey(searchName)) {
                for (var entry : map.entrySet()) {
                    if (entry.getKey().equals(searchName)) {
                        System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue()));
                    }
                }
            } else {
                System.out.println("Contact " + searchName + " does not exist.");
            }
            searchName = scanner.nextLine();
        }
    }
}
