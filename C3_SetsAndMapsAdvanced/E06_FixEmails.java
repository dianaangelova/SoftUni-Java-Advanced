package C3_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class E06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> map = new LinkedHashMap<>();
        ArrayDeque<String> stackNames = new ArrayDeque<String>();
        ArrayDeque<String> stackEmails = new ArrayDeque<String>();

        while (!input.equals("stop")) {
            if (!input.contains("@")) {
                stackNames.push(input);
            } else {

                if (input.endsWith("uk") || input.endsWith("us") || input.endsWith("com")) {
                    stackNames.pop();
                } else {
                    stackEmails.push(input);
                }
            }
            input = scanner.nextLine();
        }
        ArrayDeque<String> stackNamesReversed = new ArrayDeque<String>();
        ArrayDeque<String> stackEmailsReversed = new ArrayDeque<String>();

        while (!stackNames.isEmpty()) {
            stackNamesReversed.push(stackNames.pop());
            stackEmailsReversed.push(stackEmails.pop());
        }
        while (!stackNamesReversed.isEmpty()) {
            map.put(stackNamesReversed.pop(), stackEmailsReversed.pop());
        }

        map.entrySet().forEach(entry -> System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue()));

    }
}