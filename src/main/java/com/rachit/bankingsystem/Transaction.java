package com.rachit.bankingsystem;

import java.time.LocalDateTime;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return type + " - ₹" + amount + " - " + dateTime;
    }
}