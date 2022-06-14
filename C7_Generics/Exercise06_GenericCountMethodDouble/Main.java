package C7_Generics.Exercise06_GenericCountMethodDouble;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box box = new Box();

        while (n-- > 0) {
            Double input = Double.parseDouble(scanner.nextLine());
            box.add(input);
        }
        Double elementToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.countDouble(elementToCompare));

    }
}
