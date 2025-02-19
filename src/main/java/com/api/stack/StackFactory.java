package com.api.stack;

public class StackFactory<E> {

    /**
     * Crea una instancia de Stack según el tipo especificado.
     * 
     * @param tipo Tipo de stack ("Vector", "ArrayList" o "List").
     * @return Una instancia de Stack<E>.
     * @throws IllegalArgumentException Si el tipo no es válido.
     */
    public Stack<E> crearStack(String tipo) {
        return switch (tipo) { 
            case "Vector" -> new StackVector<>();
            case "ArrayList" -> new StackArrayList<>();
            case "List" -> new StackList<>();
            default -> throw new IllegalArgumentException("Tipo de stack no válido: " + tipo);
        };
    }
}
