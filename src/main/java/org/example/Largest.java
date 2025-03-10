package org.example;

public class Largest {
    public static int largest(int[] list) {
        int i;
//        int max = Integer.MAX_VALUE;
        int max = list[0];
        for (i = 0; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
}
