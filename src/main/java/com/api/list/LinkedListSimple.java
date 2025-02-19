package com.api.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListSimple<E> extends AbstractList<E> {

    // Nodo simple
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListSimple() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    // devuelve la cantidad de elementos de la lista
    public int size() {
        return size;
    }

    @Override
    // limpia los elementos de la lista
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    // añade un elemento al inicio de la lista
    // ubica la cabeza actual en el next de la nueva
    public void addFirst(E value) {
        head = new Node<>(value, head);
        if (size == 0) {
            tail = head;
        }
        size += 1;
    }

    @Override
    // añade un nuevo elemento al final de la lista
    // añade un nuevo nodo a la cola dela actual lista
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    @Override
    // retorna el priimer nodo de una lista
    // si la lista está vacía devuelve un valor nulo
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    // retorna un la informacion del ultimo nodo de la lista 
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    @Override
    // elimina el primer dodo de la lista, apuntando al siguiente
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E value = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return value;
    }

    @Override
    // elimina el ultimo elemento de la lista, apuntndo al penultimo elemento
    // retorna el valor del nodo eliminado
    public E removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (size == 1) {
            return removeFirst();
        }
        Node<E> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        E value = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return value;
    }

    @Override
    public void add(E value) {
        addLast(value);
    }

    @Override
    public E remove() {
        return removeLast();
    }

    @Override
    public E get() {
        return getLast();
    }

    @Override
    public E remove(E value) {
        if (isEmpty()) {
            return null;
        }

        if (head.data.equals(value)) {
            return removeFirst();
        }

        Node<E> current = head;
        
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }
        if (current.next == null) {
            return null;
        }
        
        E removedValue = current.next.data;
        current.next = current.next.next;
        
        if (current.next == null) {
            tail = current;
        }
        
        size-=1;

        return removedValue;
    }

    @Override
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
    public int lastIndexOf(E value) {
        Node<E> current = head;
        int index = 0, lastIndex = -1;
        while (current != null) {
            if (current.data.equals(value)) lastIndex = index;
            current = current.next;
            index+=1;
        }
        return lastIndex;
    }

    @Override
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
    public E set(int i, E o) {
        // si el indice no existe en la lista, lanza una excepción
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
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
    public void add(int i, E o) {
        // si el indice no existe en la lista, lanza una excepción
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            addFirst(o);
        } else {
            Node<E> current = head;
            
            for (int index = 0; index < i - 1; index++) {
                current = current.next;
            }

            current.next = new Node<>(o, current.next);
            if (current.next.next == null) {
                tail = current.next;
            }
            size+=1;
        }
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            return removeFirst();
        }

        Node<E> current = head;
        for (int index = 0; index < i - 1; index++) {
            current = current.next;
        }
        
        E value = current.next.data;
        current.next = current.next.next;
        
        if (current.next == null) {
            tail = current;
        }
        size-=1;
        return value;
    }

    @Override
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