import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {


    static double balance = 0;
    static ArrayList<String> history = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Welcome to the Bank System ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Your account is ready.");

        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    showHistory();
                    break;
                case 5:
                    System.out.println("Goodbye, " + name + "!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 5);
    }

    static void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            balance += amount;
            history.add("Deposited: $" + amount + " | Balance: $" + balance);
            System.out.println("Successfully deposited $" + amount);
        }
    }

    static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        } else {
            balance -= amount;
            history.add("Withdrew:  $" + amount + " | Balance: $" + balance);
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    static void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("--- Transaction History ---");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }


}