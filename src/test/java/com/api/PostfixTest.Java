
package com.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the Postfix class.
 * 
 * This class contains test methods to evaluate the functionality of the Postfix class,
 * which includes methods for evaluating postfix expressions and converting infix expressions
 * to postfix expressions.
 * 
 * The tests cover a variety of scenarios including:
 * - Simple and complex expressions
 * - Single number expressions
 * - Division, multiplication, subtraction, and addition operations
 * - Expressions with negative numbers
 * - Division by zero
 * - Expressions with parentheses
 * 
 * Each test method uses JUnit 5 annotations and assertions to verify the correctness of the
 * Postfix class methods.
 * 
 * Methods:
 * - testEvaluateSimpleExpression: Tests evaluation of a simple postfix expression.
 * - testEvaluateComplexExpression: Tests evaluation of a complex postfix expression.
 * - testEvaluateSingleNumber: Tests evaluation of a single number postfix expression.
 * - testEvaluateDivision: Tests evaluation of a division operation in postfix expression.
 * - testEvaluateMultiplication: Tests evaluation of a multiplication operation in postfix expression.
 * - testEvaluateSubtraction: Tests evaluation of a subtraction operation in postfix expression.
 * - testEvaluateNegativeResult: Tests evaluation of a postfix expression resulting in a negative number.
 * - testEvaluateMultipleOperations: Tests evaluation of a postfix expression with multiple operations.
 * - testEvaluateWithZero: Tests evaluation of a postfix expression with zero.
 * - testEvaluateWithNegativeNumbers: Tests evaluation of a postfix expression with negative numbers.
 * - testEvaluateDivisionByZero: Tests evaluation of a postfix expression with division by zero.
 * - testInfixToPostfixSimpleExpression: Tests conversion of a simple infix expression to postfix.
 * - testInfixToPostfixComplexExpression: Tests conversion of a complex infix expression to postfix.
 * - testInfixToPostfixSingleNumber: Tests conversion of a single number infix expression to postfix.
 * - testInfixToPostfixWithParentheses: Tests conversion of an infix expression with parentheses to postfix.
 * - testInfixToPostfixWithDivision: Tests conversion of an infix expression with division to postfix.
 * 
 * This test class was made by Marco Alejandro Díaz Castañeda
 * Carné: 24229
 * 
 */
public class PostfixTest {

    @Test
    public void testEvaluateSimpleExpression() {
        String expression = "3 4 +";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(7, result);
    }

    @Test
    public void testEvaluateComplexExpression() {
        String expression = "5 1 2 + 4 * + 3 -";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(14, result);
    }

    @Test
    public void testEvaluateSingleNumber() {
        String expression = "42";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(42, result);
    }



    @Test
    public void testEvaluateDivision() {
        String expression = "8 4 /";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(2, result);
    }

    @Test
    public void testEvaluateMultiplication() {
        String expression = "6 7 *";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(42, result);
    }

    @Test
    public void testEvaluateSubtraction() {
        String expression = "10 3 -";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(7, result);
    }

    @Test
    public void testEvaluateNegativeResult() {
        String expression = "3 10 -";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(-7, result);
    }

    @Test
    public void testEvaluateMultipleOperations() {
        String expression = "2 3 + 5 *";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(25, result);
    }

    @Test
    public void testEvaluateWithZero() {
        String expression = "0 5 +";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(5, result);
    }

    @Test
    public void testEvaluateWithNegativeNumbers() {
        String expression = "-3 -4 +";
        int result = Postfix.eval(expression, "Vector");
        assertEquals(-7, result);
    }

    @Test
    public void testEvaluateDivisionByZero() {
        String expression = "8 0 /";
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Postfix.eval(expression, "Vector");
        });
        assertEquals("/ by zero", exception.getMessage());
    }
    @Test
    public void testInfixToPostfixSimpleExpression() {
        String infix = "3 + 4";
        String postfix = Postfix.infixToPostfix(infix);
        assertEquals("3 4 +", postfix);
    }

    @Test
    public void testInfixToPostfixComplexExpression() {
        String infix = "5 + ((1 + 2) * 4) - 3";
        String postfix = Postfix.infixToPostfix(infix);
        assertEquals("5 1 2 + 4 * + 3 -", postfix);
    }

    @Test
    public void testInfixToPostfixSingleNumber() {
        String infix = "42";
        String postfix = Postfix.infixToPostfix(infix);
        assertEquals("42", postfix);
    }

    @Test
    public void testInfixToPostfixWithParentheses() {
        String infix = "( 3 + 4 ) * 2";
        String postfix = Postfix.infixToPostfix(infix);
        assertEquals("3 4 + 2 *", postfix);
    }

    @Test
    public void testInfixToPostfixWithDivision() {
        String infix = "8 / 4";
        String postfix = Postfix.infixToPostfix(infix);
        assertEquals("8 4 /", postfix);
    }


}
