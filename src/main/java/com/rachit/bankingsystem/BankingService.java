package com.rachit.bankingsystem;

import java.util.ArrayList;
import java.util.List;

public class BankingService {

    private final BankAccount account;
    private final List<Transaction> transactions = new ArrayList<>();

    public BankingService(BankAccount account) {
        this.account = account;
    }

    // Adds money to the account and records the transaction
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        account.addBalance(amount);
        transactions.add(new Transaction("Deposit", amount));

        System.out.println("₹" + amount + " deposited successfully.");
    }

    // Checks the balance before allowing a withdrawal
    public void withdraw(double amount) throws InsufficientBalanceException {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException(
                    "Insufficient balance. Available balance: ₹" + account.getBalance()
            );
        }

        account.subtractBalance(amount);
        transactions.add(new Transaction("Withdraw", amount));

        System.out.println("₹" + amount + " withdrawn successfully.");
    }

    public void showBalance() {
        System.out.println("Current balance: ₹" + account.getBalance());
    }

    public void showTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        System.out.println("\n----- Transaction History -----");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}