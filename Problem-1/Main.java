package com.Jaynish;

public class Main {

    public static void main(String[] args) {

        ArbitraryQueue aQueue = new ArbitraryQueue();
        String Jay = "Jaynish";
        aQueue.Push(Jay);
        aQueue.Enqueue("Turnpike");
        aQueue.Enqueue("Alex");
        aQueue.Push("39");
        aQueue.Push("Water");
        System.out.println(aQueue.Dequeue());
        System.out.println(aQueue.Pop());
        System.out.println((aQueue.Dequeue()));






    }
}
