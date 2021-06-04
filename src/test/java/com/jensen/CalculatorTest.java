package com.jensen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Calculator java class testing");
    }

//-------------------------------------------------------------------------
    @Nested
    @DisplayName("Getter/Setter testing")
    class whenGetterSetter {

        @Test
        @Order(1)
        @DisplayName("Setters and Getters functionality test: firstValue")
        void testSetFirstValue() {
            calculator.setFirstValue(10);

            assertNotNull(calculator);
            assertEquals(10, calculator.getFirstValue());
        }

        @Test
        @Order(2)
        @DisplayName("Setters and Getters functionality test: secondValue")
        void testSetSecondValue() {
            calculator.setSecondValue(5);

            assertNotNull(calculator);
            assertEquals(5, calculator.getSecondValue());
        }

        @Test
        @Order(3)
        @DisplayName("Setters and Getters functionality test: result")
        void testSetResult() {
            calculator.setResult(100);

            assertNotNull(calculator);
            assertEquals(100, calculator.getResult());
        }
    }
//-------------------------------------------------------------------------

    @Nested
    @DisplayName("Testing methods Adder(), Subtract(), Multiply(), Division()")
    class whenAdderSubtractMultiplyDivision {

        @ParameterizedTest
        @DisplayName("Adder test with valid input data")
        @Order(1)
        @CsvSource({"5, 3, 8", "-5, -3, -8", "-5, 3, -2", "0, 5, 5", "10, 0, 10"})
        void testAdder(double firstValue, double secondValue, double expectedResult) {
            calculator.Adder(firstValue, secondValue);
            calculator.getResult();

            assertEquals(expectedResult, calculator.getResult());
        }

        @ParameterizedTest
        @DisplayName("Subtract test with valid input data")
        @Order(2)
        @CsvSource({"5, 3, 2", "-5, -3, -2", "-5, 3, -8", "0, 5, -5", "10, 0, 10"})
        void testSubtract(double firstValue, double secondValue, double expectedResult) {
            calculator.Subtract(firstValue, secondValue);
            calculator.getResult();

            assertEquals(expectedResult, calculator.getResult());
        }

        @ParameterizedTest
        @Order(3)
        @DisplayName("Multiply test with valid input data")
        @CsvSource({"5, 3, 15", "-5, -3, 15", "-5, 3, -15", "0, 5, 0", "10, 0, 0"})
        void testMultiply(double firstValue, double secondValue, double expectedResult) {
            calculator.Multiply(firstValue, secondValue);
            calculator.getResult();

            assertEquals(expectedResult, calculator.getResult());
        }

        @ParameterizedTest
        @DisplayName("Division test with valid input data")
        @Order(4)
        @CsvSource({"15, 3, 5", "-15, -3, 5", "-15, 3, -5", "0, 5, 0"})
        void testDivisionPositive(double firstValue, double secondValue, double expectedResult) {
            calculator.Division(firstValue, secondValue);
            calculator.getResult();

            assertEquals(expectedResult, calculator.getResult());
        }

        @Test
        @DisplayName("Division by 0")
        @Order(5)
        void testDivisionNegative() {
            calculator.Division(10, 0);
            calculator.getResult();

            assertEquals(0.0, calculator.getResult());
        }
}

//-------------------------------------------------------------------------
    @Nested
    @DisplayName("Testing execute() method")
    class whenExecute {

    @Test
    @Order(1)
    @DisplayName("Test Execution method: Adder")
    void testExecuteAdder() {
        calculator.setFirstValue(100.0);
        calculator.setSecondValue(80.0);

        assertEquals(180, calculator.execute('a'));
    }

    @Test
    @Order(2)
    @DisplayName("Test Execution method: Subtract")
    void testExecuteSubtract() {
        calculator.setFirstValue(100.0);
        calculator.setSecondValue(80.0);

        assertEquals(20, calculator.execute('s'));
    }

    @Test
    @Order(3)
    @DisplayName("Test Execution method: Division")
    void testExecuteDivision() {
        calculator.setFirstValue(100.0);
        calculator.setSecondValue(20.0);

        assertEquals(5, calculator.execute('d'));
    }

    @Test
    @Order(4)

    @DisplayName("Test Execution method: Multiply")
    void testExecuteMultiply() {
        calculator.setFirstValue(100.0);
        calculator.setSecondValue(20.0);

        assertEquals(2000.0, calculator.execute('m'));
    }

    @Test
    @Order(5)
    @DisplayName("Test Execution method: default case")

    void testExecuteDefault() {
        calculator.setFirstValue(100);
        calculator.setSecondValue(1);

        assertEquals(0.0, calculator.execute('k'));
    }
}

}