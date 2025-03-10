package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String owner;
    private List<String> cards;
    private int cash;
    private int coins;

    public Wallet() {
        this.owner = null;
        this.cards = new ArrayList<>();
        this.cash = 0;
        this.coins = 0;
    }

    // Fungsi untuk set data owner
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Fungsi untuk get data owner
    public String getOwner() {
        return owner;
    }

    // Fungsi untuk menambahkan kartu
    public void addCard(String card) {
        cards.add(card);
    }

    // Fungsi untuk mendapatkan daftar kartu
    public List<String> getCards() {
        return cards;
    }

    // Fungsi untuk menambahkan uang
    public void addMoney(int cash, int coins) {
        if (cash < 0 || coins < 0) {
            throw new IllegalArgumentException("Jumlah uang tidak boleh negatif");
        }
        this.cash += cash;
        this.coins += coins;
    }

    // Fungsi untuk menarik uang
    public boolean withdrawMoney(int cash, int coins) {
        if (cash <= this.cash && coins <= this.coins) {
            this.cash -= cash;
            this.coins -= coins;
            return true;
        }
        return false; // Saldo tidak cukup
    }

    // Fungsi untuk menampilkan jumlah uang yang ada di dalam dompet
    public int getTotalMoney() {
        return this.cash + this.coins;
    }
}
