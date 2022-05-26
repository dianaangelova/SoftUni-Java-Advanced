package C1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputCommands = scanner.nextLine().split(" ");
        String[] inputNumbers = scanner.nextLine().split(" ");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberToPop = Integer.parseInt(inputCommands[1]);

        int numberToCompare = Integer.parseInt(inputCommands[2]);

        for (String s:inputNumbers) {
            stack.push(Integer.valueOf(s));
        }
        for (int i = 0; i < numberToPop; i++) {
            stack.pop();
        }
        int minNumber= Integer.MAX_VALUE;
        if (stack.contains(numberToCompare)){
            System.out.println("true");
        } else if (!stack.isEmpty()){
            for (Integer i: stack) {
                if (i<minNumber){
                    minNumber=i;
                }
            }
            System.out.println(minNumber);
        } else {
            System.out.println(0);
        }

        //System.out.println();
    }
}
