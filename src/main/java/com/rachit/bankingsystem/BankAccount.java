package com.rachit.bankingsystem;

/*
 * Holds the basic information of a bank account.
 * Balance is kept private so it can only be changed through
 * the account methods.
 */
public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Used when money is deposited into the account
    public void addBalance(double amount) {
        balance += amount;
    }

    // Used after checking that the account has enough balance
    public void subtractBalance(double amount) {
        balance -= amount;
    }
}