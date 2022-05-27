package C3_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E01_UniqueUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            usernames.add(data);
        }

        //System.out.println(String.join(System.lineSeparator(), usernames));

        for (String u : usernames) {
            System.out.println(u);
        }

      //  usernames.forEach(System.out::println);
    }

}
