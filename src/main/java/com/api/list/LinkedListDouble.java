package com.api.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDouble<E> extends AbstractList<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> back;

        Node(E data, Node<E> next, Node<E> back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListDouble() {
        head = tail = null;
        size = 0;
    }

    @Override
    // retorna el tamaño de la lista
    public int size() { 
        return size;
    }

    @Override
    // vacía la lista enlazada
    public void clear() { 
        head = tail = null;
        size = 0;
    }

    @Override
    // agrega un elemento al inicio de la lista
    public void addFirst(E value) { 
        Node<E> newNode = new Node<>(value, head, null);
        
        if (head != null) {
            head.back = newNode;
        }
        
        head = newNode;
        
        if (tail == null) {
            tail = newNode;
        }
        
        size+=1;
    }

    @Override
    // agrega un elemento al final de la lista
    public void addLast(E value) { 
        Node<E> newNode = new Node<>(value, null, tail);
        
        if (tail != null) {
            tail.next = newNode;
        }
        
        tail = newNode;
        
        if (head == null) {
            head = newNode;
        }
        
        size+=1;
    }

    @Override
    // retorna el primer elemento de la lista
    public E getFirst() { 
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    // retorna el último elemento de la lista
    public E getLast() { 
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    @Override
    // elimina el primer elemento de la lista
    public E removeFirst() { 
        if (isEmpty()) {
            return null;
        }
        
        E value = head.data;
        head = head.next;
        
        if (head != null) {
            head.back = null;
        } else {
            tail = null;
        }
        
        size-=1;
        
        return value;
    }

    @Override
    // elimina el último elemento de la lista
    public E removeLast() { 
        if (isEmpty()) {
            return null;
        }

        E value = tail.data;
        tail = tail.back;
        
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        
        size-=1;
        return value;
    }

    @Override
    // agrega un elemento al final de la lista
    public void add(E value) { 
        addLast(value);
    }

    @Override
    // elimina el último elemento de la lista
    public E remove() { 
        return removeLast();
    }

    @Override
    // retorna el último elemento de la lista
    public E get() { 
        return getLast();
    }

    @Override
    // retorna el índice de la primera aparición del elemento
    public int indexOf(E value) { 
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index+=1;
        }
        return -1;
    }

    @Override
    // retorna el índice de la última aparición del elemento
    public int lastIndexOf(E value) { 
        Node<E> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.back;
            index-=1;
        }
        return -1;
    }

    @Override
    // retorna el elemento en el índice especificado
    public E get(int i) { 
        if (i < 0 || i >= size) {
            return null;
        }
        Node<E> current = head;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    // reemplaza el elemento en el índice especificado
    public E set(int i, E o) { 
        if (i < 0 || i >= size) {
            return null;
        }
        
        Node<E> current = head;
        
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        
        E oldValue = current.data;
        current.data = o;
        
        return oldValue;
    }

    @Override
    // inserta un elemento en el índice especificado
    public void add(int i, E o) { 
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            addFirst(o);
        } else if (i == size) {
            addLast(o);
        } else {
            Node<E> current = head;
            for (int index = 0; index < i - 1; index++) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(o, current.next, current);
            current.next.back = newNode;
            current.next = newNode;
            size++;
        }
    }

    @Override
    // elimina el elemento en el índice especificado
    public E remove(int i) { 
        if (i < 0 || i >= size) {
            return null;
        }

        if (i == 0) {
            return removeFirst();
        }
        
        if (i == size - 1) {
            return removeLast();
        }
        
        Node<E> current = head;
        
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        
        E value = current.data;
        current.back.next = current.next;
        current.next.back = current.back;
        size-=1;
        return value;
    }

    @Override
    // elimina la primera aparición del elemento
    public E remove(E value) { 
        Node<E> current = head;
        
        while (current != null) {
            if (current.data.equals(value)) {
                if (current.back != null) {
                    current.back.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.back = current.back;
                } else {
                    tail = current.back;
                }
                size-=1;
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    // retorna un iterador para recorrer la lista
    public Iterator<E> iterator() { 
        return new Iterator<E>() {
            private Node<E> current = head;
            
            @Override
            public boolean hasNext() { 
                return current != null; 
            }
            
            @Override
            public E next() {
                if (!hasNext()) {
                    return null;
                }

                E value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}
