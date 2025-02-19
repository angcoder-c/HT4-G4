package com.api;

import com.api.stack.Stack;
import com.api.stack.StackFactory;

/**
 * The Postfix class provides a method to evaluate postfix expressions.
 * Made by: Marco Alejandro Díaz Castañeda
 * Carné: 24229
 * adapted from HT2 https://github.com/eldmark/hdt2Stack.git
 * 
 */

public class Postfix {

    /**
     * Converts an infix expression to a postfix expression.
     *
     * @param expression the infix expression to convert
     * @return the postfix expression as a string
     * based from https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/
     * 
     */
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new StackFactory<Character>().crearStack("ArrayList");
        String operators = "+-*/%";

        for (char token : expression.toCharArray()) {
            if (Character.isDigit(token)) {
                result.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else if (operators.indexOf(token) != -1) {
                while (!stack.empty() && precedence(stack.peek()) >= precedence(token)) {
                    result.append(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.empty()) {
            result.append(stack.pop());
            result.append(" ");
        }

        return result.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    /**
     * Evaluates a postfix expression using a specified type of stack.
     *
     * @param expression the postfix expression to evaluate, with tokens separated
     *                   by spaces
     * @param tipo       the type of stack to use (e.g., "ArrayList", "LinkedList")
     * @return the result of the evaluated postfix expression
     * @throws IllegalArgumentException if an invalid operator is encountered in the expression
     */
    public static int eval(String expression, String tipo) {
        Stack<Integer> pila = new StackFactory<Integer>().crearStack(tipo);

        for (String token : expression.split(" ")) {
            if (token.matches("-?\\d+")) {
                pila.push(Integer.parseInt(token));
            } else {
                int b = pila.pop();
                int a = pila.pop();
                switch (token) {
                    case "+":
                        pila.push(a + b);
                        break;
                    case "-":
                        pila.push(a - b);
                        break;
                    case "*":
                        pila.push(a * b);
                        break;
                    case "/":
                        pila.push(a / b);
                        break;
                    case "%":
                        pila.push(a % b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        return pila.pop();
    }
}