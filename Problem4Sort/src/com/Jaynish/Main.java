package com.Jaynish;

public class Main {

    public static void main(String[] args) {

    }

    public static void Problem4A(int[] a, int arraySize) {

        // minima array
        int[] b = new int[arraySize];
        b = a.clone();
        int i = 0;

        while (i < arraySize && i + 1 < arraySize) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                i += 2;
            } else {
                i++;
            }
        }
        System.out.println("Minima:");
        for (i = 0; i < arraySize; i++) {
            System.out.print(a[i] + " ");
        }


        int k = 0;

        while (k < b.length && k + 1 < b.length) {
            if (b[k] < b[k + 1]) {
                int temp = b[k];
                b[k] = b[k + 1];
                b[k + 1] = temp;
                k += 2;
            } else {
                k++;
            }
        }

        System.out.println("\n");
        System.out.print("Maxima:");

        for (k = 0; k < b.length; k++) {
            System.out.print(b[k] + " ");
        }

    }
}
