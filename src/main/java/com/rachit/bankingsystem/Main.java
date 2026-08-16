package com.rachit.bankingsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount(
                "AC1001",
                "Rachit Sharma",
                10000
        );

        BankingService bankingService = new BankingService(account);

        boolean running = true;

        System.out.println("================================");
        System.out.println("        Simple Banking App");
        System.out.println("================================");
        System.out.println("Welcome, " + account.getAccountHolder());

        while (running) {

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();

                    bankingService.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    try {
                        bankingService.withdraw(withdrawAmount);
                    } catch (InsufficientBalanceException e) {
                        System.out.println("Transaction failed: " + e.getMessage());
                    }
                    break;

                case 3:
                    bankingService.showBalance();
                    break;

                case 4:
                    bankingService.showTransactions();
                    break;

                case 5:
                    running = false;
                    System.out.println("\nThank you for using the banking app.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        }

        scanner.close();
    }
}