package C6_DefiningClasses.Lab03_BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int nextID = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = nextID;
        nextID++;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * balance * years;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public int getId() {
        return id;
    }
}
