package com.Jaynish;

public class Main {

    public static void main(String[] args) {

	// write your code here


    }
    public static void mergeSort(int [] a){
        int middle = 0;
        if(a.length % 2 == 0){
             middle =  a.length/2;
        }else{
            middle = a.length/2 + 1;
        }


        // sort front half
        for (int j =0; j< middle -1; j++) {
            for (int i = 0; i < middle - 1; i++) {
                if (a[i + 1] < a[i]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }

        // sort second half
        for (int j =middle; j< a.length-1; j++) {
            for (int i = middle; i < a.length - 1; i++) {
                if (a[i + 1] < a[i]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }

        // merge sort
        System.out.println("\n");
        for (int i = 0; i < middle-1; i++){
            for(int j = middle; j<a.length; j++){
                if (a[j]<a[i]){
                    int temp = a[j];
                    for(int k = j; k > i-1; k--){
                        if(k-1 >= 0) {
                            a[k] = a[k - 1];
                        }
                    }
                    a[i] = temp;
                    i++;
                }
            }
        }

       for (int j =0; j < a.length; j++){
            System.out.print(a[j]+" ");
       }
    }
}

