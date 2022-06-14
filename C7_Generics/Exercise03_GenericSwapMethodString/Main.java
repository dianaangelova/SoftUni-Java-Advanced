package C7_Generics.Exercise03_GenericSwapMethodString;

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
        String[] indices = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(indices[0]);
        int secondIndex = Integer.parseInt(indices[1]);

        box.swapElements(firstIndex, secondIndex);
        System.out.print(box);

    }
}
