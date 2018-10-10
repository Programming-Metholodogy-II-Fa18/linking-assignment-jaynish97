package com.Jaynish;


class LinkedList{
    private Node first;
    private Node current;
    private Node last;
    private int nElems;

    class Node {
        int val;
        Node next;
        Node previous;

        public Node(int val) {
            this.val = val;
        }

        public void print() {
            if(this.next != null) {
                System.out.println(this.val+"-->"+this.next.val);
            }
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    public LinkedList() {
        nElems = 0;
    }
    private Boolean isEmpty(){
        return (first == null);
    }

    public void add(int num) { // function to add element to list
        Node node = new Node(num); //create new node w/ value = num
        if(isEmpty()) {  // if list is empty case
            first = node;
            last = node;
            return;
        }

        current = first; // set current equal to first node

        while(current.next != null) { // loop till current is equal to last node
            current = current.next;
        }

        node.previous = current; // current is previous of new node
        current.next = node;
        last = node; // set last node = to new input node
        nElems++; // increase nElems
    }

    public void printList() { //function to print out linked list
        Node elem = first; // element is reference to first
        while(elem.next != null) {
            System.out.print(elem.val+" , "); // prints value of current element
            elem = elem.next; // moves element
        }
        System.out.println(elem.val); // prints final element
    }


    private void shuffle() { // function to shuffle linked list
        System.out.println("Shuffle:");
        Node node1;
        Node node2;
        for (int i = 0; i < 100; i++){  // 100 swaps for the shuffle
            node1 = first; // set node 1 to reference first
            int rand1 = (int) (Math.random() * (nElems)+1);  // generate random to figure out which node to switch

            for (int j = 0; j < rand1; j++){
                node1 = node1.next; // find node
            }
            swap(node1,first); // swap first and node
        }
        this.printList(); //print list
    }



    private void removeAndAdd(Node node1, Node node2) { // algo compares number next to pivot with pivot if pivot >  next switch current to front
        if(node1.previous != null && node1.next != null) {
            node1.previous.next = node1.next; //
            node1.next.previous = node1.previous;
        }
        if(node1.next == null) {
            node1.previous.next = null;
             last = node1.previous;
        }
        if(node1.previous == null) {
            node1.next.previous = null;
            first = node1.next;
        }
        if(node2.previous != null) {
            node2.previous.next = node1;
            node1.previous = node2.previous;
            node2.previous = node1;
            node1.next = node2;
        }
        if(node2.previous == null) {
            node2.previous = node1;
            node1.next = node2;
            node1.previous = null;
            first = node1;
        }
        System.out.println("Removing "+node1.val+" and adding before "+node2.val);
        this.printList();
    }

    private void swap(Node node1, Node node2) {
        int temp = node1.val; //set node1's value to temp variable
        node1.val = node2.val; // set node2's value to node1's value
        node2.val = temp; // set node2's value to temp
        System.out.println("Swap "+node1.val+" and "+node2.val+"!");
    }


    private void partition(Node node1, Node node2) {
        if(node1.next == null) {  // if list contains only one item return
            return;
        }
        if(node1 == node2 || (node1.next == node2 && node1.val <= node2.val)) { // if node1 and node are equal return or if node1.next == node 2 and node1 num <= node2 num
            return;
        }
        if(node1.next == node2 && node1.val > node2.val) { // if node1.next == node2  and node1 val > node2 val
            swap(node1,node2); // swap node 1 and node 2
            return;
        }
        Boolean start = false;
        Node pivot = node1; // pivot  set to node1
        Node next_node1 = null;
        Node cep = null;
        current = node1.next; // set current to node1.next
        while(current.next != null && current.next != node2) {
            if(current.val == pivot.val) { // if current is equal to pivot
                System.out.println(current.val+" = "+pivot.val);
                Node temp;
                temp = current.next; //  temp is set to current.next
                removeAndAdd(current,pivot); //
                if(!start) {
                    next_node1 = current; //
                }
                current = temp;  //  current set to its old next item
            }
            else if(current.val < pivot.val) { //  current is less then
                System.out.println(current.val+" < "+pivot.val);
                Node temp;
                temp = current.next; // temp set to current.next
                if(cep != null) {
                    removeAndAdd(current,cep);
                }
                removeAndAdd(current, first);
                start = true;
                next_node1 = current;
                current = temp; // current set to temp
            }
            else {
                System.out.println(current.val+ " > " + pivot.val);
                current = current.next;
            }
        }

        if(current.next != null) {
            current = current.next; // current set to next
        }
        if(current.val == pivot.val) {
            System.out.println(current.val+" = "+pivot.val);
            removeAndAdd(current,pivot);
            cep = current; // current was equal to pivot
        }
        else if(current.val < pivot.val) {
            System.out.println(current.val+" < "+pivot.val);
            removeAndAdd(current, first);
        }
        if(next_node1 == null) {
            next_node1 = node1;
        }
        this.printList();
        if(cep != null) {
            this.partition(next_node1, cep);
        }
        else if(next_node1 != null){
            this.partition(next_node1, pivot);
        }
        if(pivot.next != null) {
            this.partition(pivot.next, node2);
        }
    }



    public void quicksort() {
        this.shuffle(); // call shuffle

        if(isEmpty() || first.next == null) {
            return;
        }


        this.partition(first,last); // call partition algo



    }

}

