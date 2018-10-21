package com.Jaynish;

import java.util.ArrayList;

public class BST {

     class Node{
         int data;
         Node leftChild;
         Node rightChild;
    }

     private Node root;
     private  int nElems;
     private int pos = 0;
     private int[] arr = new int[10];
     private int count = 0;

    public BST(){
        root = null;
        nElems = 0;
    }

    public void put(int a){
        Node node = new Node();
        node.data = a;
        nElems++;

        if (root == null){
            root = node;
        }


        else {
            Node current = root;
            Node parent;
            while(true){

                    parent = current;
                    if(a < current.data) // go left?
                    {
                        current = current.leftChild;
                        if(current == null) // if end of the line,
                        { // insert on left
                            parent.leftChild = node;
                            return;
                        }
                    } // end if go left
                    else // or go right?
                    {
                            current = current.rightChild;
                        if(current == null) // if end of the line
                        { // insert on right
                            parent.rightChild = node;
                            return;
                        }
                    } // end else go right
                }
        }



    }

    public void put(int[] a){
        for (int i = 0; i < a.length; i++){
            put(a[i]);

        }
    }

    public int search( int key){
        Node current = root;
        int n = 0;
        while(true) {
            if (key < current.data) {
                current = current.leftChild;
                n++;

                if(current == null){
                    System.out.println("Not Found: " + n + " comparisons needed");
                    return 0;
                }

            } else if (key > current.data){
                current = current.rightChild;
                n++;
                if (current ==null){
                    System.out.println("Not Found: " + n + " comparisons needed");
                    return 0;
                }
            } else {
                System.out.println("Found: " + n + " comparisons neeeded");
                return current.data;
            }
        }
    }

    public int returnSize(){
        System.out.println("Size: " + nElems);
        return nElems;
    }

    public int[] sortedTree() {
        arr = new int[nElems];
        count = 0;
        sortedTreer(root);
        return arr;
    }

    public void sortedTreer(Node root) {
        if (root != null) {
            sortedTreer(root.leftChild);
            arr[count] = root.data;
            count++;
            sortedTreer(root.rightChild);
        }
    }

    public BST balanceTreeOne(){
        this.sortedTree();
        BST balance = new BST();
        balance.root = balanceTreeOne(arr, 0, arr.length-1);
        balance.nElems = nElems;
        return balance;
    }

    public Node balanceTreeOne(int[] arr, int front, int tail){
        if (front > tail){
            return null;
        }
        int center  = (tail + front) /2 ;
        Node node = new Node();
        node.data = arr[center];
        node.leftChild = balanceTreeOne(arr,front, center-1);
        node.rightChild = balanceTreeOne(arr,center+1, tail);
        return node;
    }


    public Node rotateRight(Node node){
        if (node.leftChild == null){
            return node;
        }

        Node current = node.leftChild;
        current.leftChild = node.rightChild;
        current.rightChild = node;

        return current;
    }

    public Node rotateLeft(Node node){
        if (node.rightChild == null){
            return node;
        }

        Node current = node.rightChild;
        current.rightChild = node.leftChild;
        current.leftChild = node;
        return current;
    }

    public void transformToList() {


        while (root.leftChild != null) {
            root = rotateRight(root);
        }
        Node temp = root;
        while (temp.leftChild != null) {
            temp = temp.rightChild;
            while (temp.leftChild != null) {
                temp = rotateRight(temp);
            }
        }


    }







    // B C D E





}
