package C3_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class L09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> map = new LinkedHashMap<>();

        System.out.println(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
