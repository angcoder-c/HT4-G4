package com.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class PostfixTest {

    @Test
    public void testEvaluateSimpleExpression() {
        Postfix postfix = new Postfix();
        String expression = "3 4 +";
        int result = postfix.evaluate(expression);
        assertEquals(7, result);
    }

    @Test
    public void testEvaluateComplexExpression() {
        Postfix postfix = new Postfix();
        String expression = "5 1 2 + 4 * + 3 -";
        int result = postfix.evaluate(expression);
        assertEquals(14, result);
    }

    @Test
    public void testEvaluateSingleNumber() {
        Postfix postfix = new Postfix();
        String expression = "42";
        int result = postfix.evaluate(expression);
        assertEquals(42, result);
    }

    @Test
    public void testEvaluateEmptyExpression() {
        Postfix postfix = new Postfix();
        String expression = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            postfix.evaluate(expression);
        });
        assertEquals("Expression is empty", exception.getMessage());
    }

    @Test
    public void testEvaluateInvalidExpression() {
        Postfix postfix = new Postfix();
        String expression = "3 4 + +";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            postfix.evaluate(expression);
        });
        assertEquals("Invalid postfix expression", exception.getMessage());
    }
}