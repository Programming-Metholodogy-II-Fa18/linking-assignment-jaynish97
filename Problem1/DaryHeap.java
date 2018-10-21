package com.Jaynish;

import java.util.NoSuchElementException;

public class DaryHeap {

    private int d; // number of children allowed
    private int[] heap_array; // array
    private int nElems; // nElems

    public DaryHeap(int d) { // constructor
        this.d = d;
        nElems = 0;
        heap_array = new  int [10];
    }


    private boolean isFull(){ // check if full
        return nElems == heap_array.length;
    } // check if heap is full

    public void insert(int k){ // insert integer k
        if (isFull()){
            doubleArray();  // double array if heap is full
        }

        heap_array[nElems++] = k; //insert elements
        swim(nElems-1);  // balance heap
        System.out.println("Inserting " + k + " ...");
        printArray();
    }

    private void swim(int k){  // balance heap upon insertion
        int temp = heap_array[k]; // set temp equal to variable just added


        while (k > 0 &&  temp > heap_array[(k-1)/d]){ // while node is greater than its parents

            heap_array[k] = heap_array[(k-1)/d]; // set child node equal to parent node
            k = (k-1)/d; // k  = location of parent node is now k

        }

        heap_array[k] = temp; // of child value is now parent value
    }

    public int delMax(){ // function to delete max

        int data = heap_array[0];    // max number
        heap_array[0] = heap_array[nElems-1]; // set root too  most recent child
        heap_array[nElems-1] = 0;
        nElems--; // decrease num elements
        sink(0);  // balance
        System.out.println("Max Deleted:");
        printArray();
        return data;


    }

    private void sink(int k){  // function to balance upon deletion
        int temp = heap_array[k];  // set root equal to temp
        int child_node;

        while (location(k,1)< nElems){

            child_node = findLargestChild(k); // find the largest child of parent

            if(heap_array[child_node] > temp){ // if child > parent
                heap_array[k] = heap_array[child_node]; // swap

            }else
                 break;

            k = child_node; // swap

        }

        heap_array[k] = temp; // swap

    }

    private int location(int k,int i){ // location of ith child of parent
        return (d*k )+ i;
    }

    private int findLargestChild(int k){
        int first = location(k, 1); // location of first child
        int i = 2;
        int current = location(k,i); // location of child to compare with first

        while (i<=d){
            if (heap_array[current] > heap_array[first]){ // test to find largest child
                first = current;
                current = location(k,i++);
            }
            else{
                i++;
            }
        }
        return first; // return largest child


    }

    public void printArray(){  // function to print array
        for (int i = 0; i<heap_array.length; i++){
            System.out.print(heap_array[i] + " " );
        }
        System.out.println("\n");
    }

    private int[] doubleArray(){  // double size of array if full
        int[] temp = new int[heap_array.length * 2];
        for (int i = 0; i<heap_array.length; i++){
            temp[i] = heap_array[i];
        }
        heap_array = temp;
        return heap_array;

    }




    public int[] daryHeapsort(){  // heapsort function
        int N = nElems-1;
        for (int i = N/2; i >=0; i--){  //
            sort(heap_array,i);

        }
        int k = nElems;

        for (int i = k; i > 1; i--){
            int temp = heap_array[0];    // set temp = to root
            heap_array[0] = heap_array[i-1]; // set root to most recent child
            heap_array[i] = temp;  // most recent child = root
            nElems--; // decrease nELems
            sort(heap_array,0);
        }


        System.out.println("Sorted Array:");
        printArray();
        return heap_array;
    }



    private void sort(int[] arr, int index) {
        int left = 2 * index;  // left  = 2 * current root
        int right = 2 * index + 1;  // right = 2 * current root plus 1
        int max = index; // set max = root index
        if (left <= nElems - 1 && arr[left] > arr[index]) // if left child great than parent
        {
            max = left; // max = left
        }
        if (right <= nElems - 1 && arr[right] > arr[max])  // if right child great than parent
            {
            max = right; // max = right
            }

        if (max != index)  // only called if max =! root;
        {
            int temp = arr[max];  //swap max and index given
            arr[max] = arr[index];
            arr[index] = temp;

            sort(arr, max); // recursive call sort with arr and new max
        }
    }





}
