package com.aaronxyzheng.calculatorparser.datastructures;

import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> queue = new ArrayList<>(); // Array List;

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        T firstItem = queue.get(0);
        queue.remove(0);
        return firstItem;
    }

    public T peek() {
        T firstItem = queue.get(0);
        return firstItem;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
