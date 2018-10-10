package com.Jaynish;

public class Main {

    public static void main(String[] args) {




    }

    public static int findMax(int[] a){ //function to determine max number in array

        int max = a[0]; // initialize max to first element in array
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i]; // determine new max
        }
        return max; // return largest number
    }


    public static void Problem1Sort(int[] a){
        int place = 1; // initially in ones digit

        int[] sorted = new int[a.length];
        int x = findMax(a); // find the max of the array
        while(x/place >0) {
            int[] count = new int[a.length]; // count array
            for (int i = 0; i < a.length; i++) {
                count[(a[i]/place)%10]++;// get count for each digit with distinct value
                // place count in appropriate index
            }
            for (int i = 1; i < 10; i++){
                count[i] += count[i-1]; // modify count by adding previous counts
            }
            for (int i = a.length-1; i>= 0; i--){ // working backwards
                sorted[--count[(a[i]/ place)%10]] = a[i]; //place integers in the correct
                // output positions and decrease count by one
            }
            for (int i = 0; i < a.length; i++){
                a[i] = sorted[i]; // copy the sorted array onto the input array
            }
            place *=10; // move from ones spot to tens spot to hundreds to etc...
        }
        for(int i =0; i < a.length; i++){
            System.out.print(a[i]+ " ");
        }

    }
}
