package C6_DefiningClasses.Lab03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Map<Integer, BankAccount> map = new HashMap<>();

        while (!tokens[0].equals("End")) {
            String output = null;
            String command = tokens[0];
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                int key = bankAccount.getId();
                map.put(key, bankAccount);
                output = "Account ID" + key + " created";
            } else if (command.equals("Deposit")) {
                int key = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                BankAccount bankAccount = map.get(key);
                if (bankAccount != null) {
                    bankAccount.deposit(amount);
                    output = "Deposited " + amount + " to ID" + key;
                } else {
                    output = "Account does not exist";
                }

            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(interest);
            } else if (command.equals("GetInterest")) {
                int key = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                BankAccount bankAccount = map.get(key);
                if (bankAccount != null) {
                    bankAccount.getInterest(years);
                    output = (String.format("%.2f", bankAccount.getInterest(years)));
                } else {
                    output = "Account does not exist";
                }
            }
            if(output!=null){
                System.out.println(output);
            }
            tokens = scanner.nextLine().split("\\s+");
        }
    }
}
