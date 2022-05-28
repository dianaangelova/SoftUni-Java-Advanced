package C3_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] length = scanner.nextLine().split(" ");

        int sizeFirst = Integer.parseInt(length[0]);
        int sizeSecond = Integer.parseInt(length[1]);

        Set<Integer> firstElements = new LinkedHashSet<>();
        Set<Integer> secondElements = new LinkedHashSet<>();

        for (int i = 0; i < sizeFirst; i++) {
            firstElements.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < sizeSecond; i++) {
            secondElements.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> commonElements = new LinkedHashSet<>();


        firstElements.retainAll(secondElements);

        for (Integer e : firstElements) {
            System.out.print(e);
            System.out.print(" ");
        }
    }
}

