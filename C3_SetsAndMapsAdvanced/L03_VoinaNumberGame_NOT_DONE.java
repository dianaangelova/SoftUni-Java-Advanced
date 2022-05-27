package C3_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class L03_VoinaNumberGame_NOT_DONE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split(" ");

        Stream<String> stream = Arrays.stream(split);

        IntStream intStream= stream.mapToInt(Integer::parseInt);



    }
}
