package com.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PostfixTest {

    @Test
    public void testEvaluateSimpleExpression() {
        String expression = "3 4 +";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(7, result);
    }

    @Test
    public void testEvaluateComplexExpression() {
        String expression = "5 1 2 + 4 * + 3 -";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(14, result);
    }

    @Test
    public void testEvaluateSingleNumber() {
        String expression = "42";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(42, result);
    }

    @Test
    public void testEvaluateEmptyExpression() {
        String expression = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Postfix.eval(expression, "ArrayList");
        });
        assertEquals("Expression is empty", exception.getMessage());
    }

    @Test
    public void testEvaluateInvalidExpression() {
        String expression = "3 4 + +";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Postfix.eval(expression, "ArrayList");
        });
        assertEquals("Invalid postfix expression", exception.getMessage());
    }

    @Test
    public void testEvaluateDivision() {
        String expression = "8 4 /";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(2, result);
    }

    @Test
    public void testEvaluateMultiplication() {
        String expression = "6 7 *";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(42, result);
    }

    @Test
    public void testEvaluateSubtraction() {
        String expression = "10 3 -";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(7, result);
    }

    @Test
    public void testEvaluateNegativeResult() {
        String expression = "3 10 -";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(-7, result);
    }

    @Test
    public void testEvaluateMultipleOperations() {
        String expression = "2 3 + 5 *";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(25, result);
    }

    @Test
    public void testEvaluateWithZero() {
        String expression = "0 5 +";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(5, result);
    }

    @Test
    public void testEvaluateWithNegativeNumbers() {
        String expression = "-3 -4 +";
        int result = Postfix.eval(expression, "ArrayList");
        assertEquals(-7, result);
    }

    @Test
    public void testEvaluateDivisionByZero() {
        String expression = "8 0 /";
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Postfix.eval(expression, "ArrayList");
        });
        assertEquals("/ by zero", exception.getMessage());
    }
}
