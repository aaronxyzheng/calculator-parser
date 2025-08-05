package com.aaronxyzheng.calculatorparser.datastructures;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        T topItem = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return topItem;
    }

    public T peek() {
        T topItem = stack.get(stack.size() - 1);
        return topItem;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
