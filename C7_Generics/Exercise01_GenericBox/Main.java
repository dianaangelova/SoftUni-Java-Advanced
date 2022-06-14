package C7_Generics.Exercise01_GenericBox;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();

            Box box = new Box();
            box.add(input);
            System.out.print(box.toString());

        }
    }
}
