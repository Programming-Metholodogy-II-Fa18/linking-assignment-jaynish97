package com.Jaynish;

public class ArbitraryQueueArray {
    private int maxSize;
    private Object[] queArray;
    private int head;
    private int tail;
    private int nItems;

    public ArbitraryQueueArray(int s ){
        this.maxSize = s; // max size of array
        this.queArray = new Object[maxSize]; // create array
        this.nItems = 0; // currently empty
        this.head =maxSize/2;
        this.tail =maxSize/2 + 1;
    }

    public void  Enqueue(Object item){ //insert at rear
        queArray[this.tail++] = item; // increase rear then add
        this.nItems++; // increase items
        //this.tail++; // move rear up
        if (isFull()) { // if rear is at end of array
            Object[] copy = new Object[this.maxSize * 2]; // double the size of the array
            for(int i = 0; i < this.maxSize; i++){
                copy[i + this.maxSize/2] = queArray[i]; // copy the smaller array into the center of the new array
            }
            this.head = this.maxSize / 2; // new head
            this.tail = this.maxSize / 2+ nItems; // new tail
            this.maxSize = this.maxSize * 2; // new maxsize
            this.queArray = copy;
        }

    } // [ x x x 3 4 5 6 7 x x]

    public void Push(Object object){ // insert at front
        queArray[this.head--] = object; //increment then add
        this.nItems++; // increase items
        //this.head--;
        if (isFull()) {
            Object[] copy = new Object[this.maxSize * 2];
            for(int i = 0; i < this.maxSize; i++){
                copy[i + this.maxSize/2] = queArray[i];
            }
            this.head = this.maxSize / 2;
            this.tail = this.maxSize / 2 + nItems;
            this.maxSize = this.maxSize * 2;
            this.queArray = copy;
        }
    }

    public Object Pop(){ //remove from head
        Object item = queArray[++head]; // get item then increase front
        if (item == null){
            return "Queue is empty";
        }
        //head++;
        nItems--;
        return item;
    }
    public Object Dequeue(){ //remove from tail
         Object item = queArray[--tail];
         if(item == null){

             return "Queue is empty";
         }
         //this.tail--;
         this.nItems--;
         return item;

    }
    public Object Traverse(int index){
        try{
            Object item = this.queArray[index];
            if(item == null){
                return "Not item exists in this index";
            }
            return item;
        }catch (IndexOutOfBoundsException e){
            return "No item exists in this index";
        }
    }

    private boolean isFull(){
        return (this.head < 0 || this.tail > this.maxSize-1);
    }

}
// 3 6 7
