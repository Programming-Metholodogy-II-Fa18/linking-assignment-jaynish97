package com.Jaynish;

public class Stack1 {


    private class Node {
        private int data;
        private Node next;

        private Node(int data){
            this.data = data;
        }

    }
    private int preSort;
    private Node first;
    private Node sorted;


    public Stack1(){
        first = null;
    }

    public void Push(int data){

       Node newData = new Node(data); // new node for new data
       newData.next = this.first; // next become old first
       this.first = newData; //first becomes newData
    }
    public void InsertionSort(){
        sorted = null; //  sorted list initialized
        Node current = first; // insert all nodes to sorted
        while (current != null){
            Node next = current.next; //
            Sort(current);// current place in sorted
            current = next; // change current
        }
        preSort = first.data;
        first  = sorted;

    }

    private void Sort(Node item){

        if (sorted == null || sorted.data >= item.data)
        {
            item.next = sorted;
            sorted = item;
        }
        else
        {
            Node node = sorted;
            // locate where node needs to be placed before insertion of item
            while (node.next != null && node.next.data < item.data)
            {
                node = node.next;
            }
            item.next = node.next;
            node.next = item;
        }
    }


    public  int Pop( ){
        int temp = this.first.data;
        this.first.data =this.first.next.data;
        return temp;
    }

    public int Peek(){ // peek
        return this.first.data;
    }
    public int pastPeek(){
        return preSort;
    }

    public void printlist(){
        while (this.first != null){
            System.out.println(this.first.data + " ");
            this.first = first.next;
        }
    }






}
