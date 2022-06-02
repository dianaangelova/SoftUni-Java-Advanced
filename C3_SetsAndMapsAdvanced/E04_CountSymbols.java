package C3_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inputText);

        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < stringBuilder.length(); i++) {

            char c = stringBuilder.charAt(i);

            map.putIfAbsent(c, 0);

            int oldCount = map.get(c);
            int newCount = oldCount+1;

            map.put(c,newCount);
        }

        for (var entry : map.entrySet()) {
            System.out.println(String.format("%c: %d time/s", entry.getKey(), entry.getValue()));
        }
    }
}
