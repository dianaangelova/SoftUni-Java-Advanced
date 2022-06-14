package C7_Generics.Exercise05_GenericCountMethodString;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box box = new Box();

        while (n-- > 0) {
            String input = scanner.nextLine();
            box.add(input);
        }

        String elementToCompare = scanner.nextLine();

        System.out.println(box.countString(elementToCompare));

    }
}
