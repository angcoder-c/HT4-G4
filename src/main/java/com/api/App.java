package com.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    /**
     * Método principal que lee expresiones de un archivo y las evalúa.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tipo = ""; //Cadena vacia 

        // Preguntar al usuario qué implementación de Stack usar
        while (true) {
            System.out.println("Seleccione el tipo de Stack a utilizar:");
            System.out.println("1. Vector");
            System.out.println("2. ArrayList");
            System.out.println("3. List");
            System.out.print("Ingrese el número de su elección: ");
            String opcion = scanner.nextLine();

            //Pasa la opción a String 
            if (opcion.equals("1")) {
                tipo = "Vector";
                break;
            } else if (opcion.equals("2")) {
                tipo = "ArrayList";
                break;
            } else if (opcion.equals("3")) {
                tipo = "List";
                break;
            } else {
                System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        // Leer y evaluar expresiones desde el archivo
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                try {
                    // Convertir de infijo a postfijo
                    String expresionPostfix = Postfix.infixToPostfix(linea);
                    System.out.println("Postfix: " + expresionPostfix);

                    // Evaluar la expresión postfija
                    int resultado = Postfix.eval(expresionPostfix, tipo);
                    System.out.println("El resultado: " + resultado);
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("Error en la expresión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

