package com.api.stack;

import java.util.Vector;

/**
 * Implementación de una pila (Stack) basada en un Vector.
 * @param <E> el tipo de elementos almacenados en la pila
 */
public class StackVector<E> implements Stack<E> {
    private Vector<E> elements;

    /**
     * Constructor que inicializa el Vector para almacenar los elementos de la pila.
     */
    public StackVector() {
        elements = new Vector<>();
    }

    /**
     * Agrega un elemento a la pila.
     * @param item el elemento a agregar
     */
    @Override
    public void push(E item) {
        elements.add(item);
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return el elemento eliminado de la cima de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    @Override
    public E pop() {
        if (empty()) {
            throw new IllegalStateException("El Stack está vacío");
        }
        return elements.remove(elements.size() - 1);
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return el elemento en la cima de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    @Override
    public E peek() {
        if (empty()) {
            throw new IllegalStateException("El Stack está vacío");
        }
        return elements.lastElement();
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario
     */
    @Override
    public boolean empty() {
        return elements.isEmpty();
    }

    /**
     * Devuelve el número de elementos en la pila.
     * @return el tamaño de la pila
     */
    @Override
    public int size() {
        return elements.size();
    }
}
