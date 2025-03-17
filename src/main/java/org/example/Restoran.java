package org.example;

public class Restoran {
    // Daftar menu restoran dan harga
    private static final String[] MENU = {"Nasi Goreng", "Mie Ayam", "Sate Ayam", "Es Teh", "Jus Alpukat"};
    private static final int[] HARGA = {15000, 12000, 20000, 5000, 10000};
    private static final boolean[] STATUS = {true, true, false, true, false};

    // Metode untuk mendapatkan harga menu tertentu
    public static int getHarga(String menu) {
        for (int i = 0; i < MENU.length; i++) {
            if (MENU[i].equalsIgnoreCase(menu)) {
                return HARGA[i];
            }
        }
        return -1; // Mengembalikan -1 jika menu tidak ditemukan
    }

    // Metode untuk menghitung total harga berdasarkan jumlah item
    public static int getTotalHarga(String menu, int jumlah) {
        int harga = getHarga(menu);
        if (harga == -1) {
            throw new IllegalArgumentException("Menu tidak tersedia: " + menu);
        }
        return harga * jumlah;
    }

    // Metode untuk memeriksa apakah menu tersedia
    public static boolean isMenuReady(String menu) {
        for (int i = 0; i < MENU.length; i++) {
            if (MENU[i].equals(menu)) {
                return STATUS[i]; // Mengembalikan status kesiapan menu
            }
        }
        return false; // Jika menu tidak ditemukan, anggap belum siap
    }
}