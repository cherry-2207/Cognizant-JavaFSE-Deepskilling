package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestExample {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    public void testOddNumbers(int number) {
        assertTrue(number % 2 != 0);
    }
}