package com.api.stack;

public class StackList <E> implements Stack<E> {
    private java.util.LinkedList<E> list;

    public StackList() {
        list = new java.util.LinkedList<>();
    }

    @Override
    public void push(E item) {
        list.addFirst(item);
    }

    @Override
    public E pop() {
        if (list.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return list.removeFirst();
    }

    @Override
    public E peek() {
        if (list.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return list.getFirst();
    }

    @Override
    public boolean empty() {
        return list.isEmpty();
    }
    @Override
    public int size() {
        return list.size();
    }

}
