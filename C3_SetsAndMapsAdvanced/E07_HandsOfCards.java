package C3_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class E07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //input = input.replaceAll("\\s+", "");
        Map<String, Set<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] inputArray = input.split(":");
            String personName = inputArray[0];
            //List<String> inputList = Arrays.stream(inputArray[1].split(",")).distinct().collect(Collectors.toList());
            String inputCardsRaw = inputArray[1].replaceAll("\\s+", "");
            String[] inputStringCards = inputCardsRaw.split(",");
            // ArrayDeque<String> inputStack = new ArrayDeque<>();
            Set<String> inputSet = new HashSet<>();
            for (String str : inputStringCards) {
                inputSet.add(str);
            }
            if (!map.containsKey(personName)) {
                map.put(personName, inputSet);
            } else {
                //List<String> inputListOLd = map.get(personName);
                Set<String> oldSet = new HashSet<>();
                oldSet = map.get(personName);
                for (String s : oldSet) {
                    inputSet.add(s);
                }
                map.put(personName, inputSet);
            }
            input = scanner.nextLine();
            input = input.replaceAll("\\s+", "");
        }

        for (String s : map.keySet()) {

            String personNameInMap = s;
            Set<String> setInMap = new LinkedHashSet<>();
            setInMap = map.get(s);
            int result = 0;
            for (String str : setInMap) {
                int multipl = 0;
                if (str.length() == 3) {

                    char thirdChar = str.charAt(2);
                    int thirdInt = 0;
                    if (thirdChar == 'S') {
                        thirdInt = 4;
                    } else if (thirdChar == 'H') {
                        thirdInt = 3;
                    } else if (thirdChar == 'D') {
                        thirdInt = 2;
                    } else if (thirdChar == 'C') {
                        thirdInt = 1;
                    } else {
                        thirdInt = Character.getNumericValue(thirdChar);
                    }
                    multipl = 10 * thirdInt;

                } else {
                    char firstChar = str.charAt(0);
                    char secondChar = str.charAt(1);
                    int firstInt = 0;
                    int secondInt = 0;

                    if (firstChar == 'J') {
                        firstInt = 11;
                    } else if (firstChar == 'Q') {
                        firstInt = 12;
                    } else if (firstChar == 'K') {
                        firstInt = 13;
                    } else if (firstChar == 'A') {
                        firstInt = 14;
                    } else {
                        firstInt = Character.getNumericValue(firstChar);
                    }
                    if (secondChar == 'S') {
                        secondInt = 4;
                    } else if (secondChar == 'H') {
                        secondInt = 3;
                    } else if (secondChar == 'D') {
                        secondInt = 2;
                    } else if (secondChar == 'C') {
                        secondInt = 1;
                    } else {
                        secondInt = Character.getNumericValue(secondChar);
                    }
                    multipl = firstInt * secondInt;
                }
                result = result + multipl;

            }
            System.out.println(s + ": " + result);
        }
    }
}
