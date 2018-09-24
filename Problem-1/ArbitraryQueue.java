package com.Jaynish;

public class ArbitraryQueue{
    private Node head; //Front of queue
    private Node tail; // end of queue

    private class Node {
        Object object;
        Node next;
        Node prev;

        private Node(Object object) { // constructor for node class
            this.object = object;
        }
    }

    public void Enqueue(Object object) { // adds to tail of queue
        Node item = new Node(object); // create new node for new item

        if (isEmpty()) { // if queue is empty
            this.head = item; // item is beginning of queue
        }
        else if (this.tail != null) { // if last is not empty
            item.prev = this.tail; // then old tail becomes the previous of the new item
            this.tail.next = item; // then add new item after the last item
        }

        this.tail = item; // the new item becomes the tail


    }

    public Object Dequeue() {// removes from tail
        try {
            Node item = this.tail; // save tail onto item
            if (this.tail.prev != null) {
                this.tail = this.tail.prev; // move tail onto previous item
            }
            else {
                this.tail = null;
                this.head = null; // else queue is empty

            }

            return item.object;
        }
        catch (NullPointerException e) {
            return "Queue is empty ";

        }
    }

    public void Push(Object object) { // adds to head of the queue
        Node item = new Node(object); // create a new node for new item
        if (isEmpty()) { // if queue is empty
            this.tail = item;
        }
        else if (this.head != null) { //as long as head is not empty
            item.next = this.head; // old head is next of new item
            this.head.prev = item; // new item is before head

        }

        this.head = item; // item become head of queue

    }

    public Object Pop() { //removes from head
        try {
            Node item = this.head; // save head onto item
            if (this.head.next != null) {
                this.head = this.head.next; // move head
            }
            else {
                this.tail = null;
                this.head = null; //else queue is empty

            }
            return item.object; // return popped item
        }

        catch (NullPointerException e) {
            return "Queue is empty";

        }

    }

    public Object Traverse(int index) {
        int num = 0; //
        try {
            Node node = this.head; // new node for head
            while (num < index) {
                node = node.next; // iterate through list
                num++; // increase count
            }
            return node.object;
        }
        catch (NullPointerException e) {

            return "Items do not exist at this index";

        }

    }

    private boolean isEmpty(){
        return (this.head == null);
    }

}