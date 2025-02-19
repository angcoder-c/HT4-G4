package com.api.list;

public class ListFactory {
    
    // crea una LinkedLispSimple
    public static <E> AbstractList<E> createSimpleLinkedList() {
        return new LinkedListSimple<>();
    }
    
    // crea una LinkedListDouble
    public static <E> AbstractList<E> createDoubleLinkedList() {
        return new LinkedListDouble<>();
    }
}