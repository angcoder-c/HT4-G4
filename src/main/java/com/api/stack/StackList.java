package com.api.stack;
import com.api.list.List;
import com.api.list.ListFactory;

public class StackList <E> implements Stack<E> {
    private List<E> list;

    public StackList(String tipo) {
        if (tipo.equals("ListSimple")) {
            list = ListFactory.createSimpleLinkedList();
        } else if (tipo.equals("ListDouble")) {
            list = ListFactory.createDoubleLinkedList();
        } else {
            list = ListFactory.createSimpleLinkedList();
        }
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
