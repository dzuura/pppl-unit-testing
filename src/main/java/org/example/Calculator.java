package org.example;

public class Calculator {
    int a, b;
    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int tambah() {
        return a+b;
    }
    public int kurang() {
        return a-b;
    }
    public int kali() {
        return a*b;
    }
    public int bagi() {
        return a/b;
    }

    // pertemuan 5
    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int multiply(int a, int b) {
        return a*b;
    }
}
