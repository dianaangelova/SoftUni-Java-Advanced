package C1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String currentURL = "blank";
        ArrayDeque<String> history = new ArrayDeque<>();
        String backURL="";
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (!history.isEmpty()) {
                    backURL=history.pop();
                    System.out.println(backURL);
                    currentURL= backURL;
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                if (!currentURL.equals("blank")) {
                    history.push(currentURL);
                }
                currentURL = command;
                System.out.println(currentURL);
            }

            command = scanner.nextLine();
        }
    }
}
