package com.jensen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class Calculator2Test {

    Calculator2 lab = new Calculator2();
    int resCounter;

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Calculator2 class tests");
    }

//-------------------------------------------------------------------------
    @Nested
    @DisplayName("Testing add(), subtract(), multiply(), divide() methods")
    class whenAddSubtractMultiplyDivide {

        @ParameterizedTest
        @Order(1)
        @DisplayName("Testing Adder() method")
        //           firstValue  secondValue   Sum
        @CsvSource({"    10,         5,        15",
                    "   -10,        -5,       -15",
                    "   -10,         5,        -5",
                    "     0,         5,         5"})
        void testAdd(int firstValue, int secondValue, int addResult) {
            assertEquals(addResult, lab.add(firstValue, secondValue));
        }

        @ParameterizedTest
        @Order(2)
        @DisplayName("Testing Subtract() method")
        //           firstValue  secondValue   Difference
        @CsvSource({"    10,         5,         5",
                    "   -10,        -5,        -5",
                    "   -10,         5,       -15",
                    "     0,         5,        -5"})
        void testSubtract(int firstValue, int secondValue, int addResult) {
            assertEquals(addResult, lab.subtract(firstValue, secondValue));
        }

        @ParameterizedTest
        @Order(3)
        @DisplayName("Testing Multiply() method")
        //           firstValue  secondValue  Product
        @CsvSource({"    10,         5,        50",
                    "   -10,        -5,        50",
                    "   -10,         5,       -50",
                    "     0,         5,         0"})
        void testMultiply(int firstValue, int secondValue, int addResult) {
            assertEquals(addResult, lab.multiply(firstValue, secondValue));
        }

        @ParameterizedTest
        @Order(4)
        @DisplayName("Testing Division() method")
        //           firstValue  secondValue  Quotient
        @CsvSource({"    10,         5,        2",
                    "   -10,        -5,        2",
                    "   -10,         5,       -2",
                    "     0,         5,        0"})
        void testDivide(int firstValue, int secondValue, int addResult) {
            assertEquals(addResult, lab.divide(firstValue, secondValue));
        }

        @Test
        //@Disabled
        @Order(5)
        @DisplayName("Division by zero")
        void testDivisionByZero()
        {
            assertThrows(ArithmeticException.class, () ->
            {
                lab.divide(10,0);

            });
            System.out.println("Counter: " + lab.getCounter());
        }
}//end whenAddSubtractMultiplyDivide

//-------------------------------------------------------------------------

    @Nested
    @DisplayName("Reverse() method testing")
    class whenReverse {

        @ParameterizedTest
        //@Disabled
        @Order(1)
        @DisplayName("Testing reverse() method with valid string")
        @CsvSource({"-abc- , -cba-"})
        void testReverseNormalString(String stringInput, String reverse) {
            assertEquals(reverse, lab.reverse(stringInput));
        }

        @ParameterizedTest
        //@Disabled
        @Order(2)
        @DisplayName("Testing reverse() method with empty string")
        @EmptySource
        void testReverse(String stringInput) {
            assertEquals("", lab.reverse(stringInput));
        }

        @ParameterizedTest
        //@Disabled
        @Order(3)
        @DisplayName("Testing reverse() method testing with null string")
        @NullSource
        void testReverseNullString(String stringInput) {
            assertThrows(NullPointerException.class,
                    () ->
                    {
                        lab.reverse(stringInput);
                    });
        }
    }
}