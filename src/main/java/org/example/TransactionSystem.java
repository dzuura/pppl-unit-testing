package org.example;

public class TransactionSystem {
    private int balance;

    public TransactionSystem(int balance) {
        this.balance =balance;
    }

    public void deposit(int deposit) {
        if (deposit > 0) {
            this.balance += deposit;
        }
        else {
            throw new IllegalArgumentException("Deposit harus ada");
        }
    }

    public void withdraw(int amount) {
        if (this.balance > amount) {
            this.balance -= amount;
        }
        else {
            throw new IllegalArgumentException("Saldo tidak mencukupi");
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public void resetBalance(int amount) {
        this.balance = amount;
    }

    public static void openConnection() {
        System.out.println("Koneksi ke server...");
    }

    public static void  closeConnection() {
        System.out.println("Menutup koneksi...");
    }
}
