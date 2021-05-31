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
        System.out.println("Calculator class tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("    ---------- Test body ----------");
    }

//-------------------------------------------------------------------------
    @Test
    @Order(1)
    @DisplayName("Setters and Getters functionality test")
    void testSettersAndGetters()
    {
       calculator.setFirstValue(10);
       calculator.setSecondValue(5);
       calculator.setResult(100);

       assertNotNull(calculator);
       assertEquals(10, calculator.getFirstValue());
       assertEquals(5, calculator.getSecondValue());
       assertEquals(100, calculator.getResult());
    }

    @ParameterizedTest
    @DisplayName("Adder test with valid input data")
    @Order(2)
    @CsvSource({"5, 3, 8", "-5, -3, -8", "-5, 3, -2", "0, 5, 5", "10, 0, 10"})
    void testAdder(double firstValue, double secondValue, double expectedResult)
    {
        calculator.Adder(5,3);
        calculator.getResult();
        System.out.println("Result: " + calculator.getResult());
        assertEquals(8, calculator.getResult());
    }

    @ParameterizedTest
    @DisplayName("Subtract test with valid input data")
    @Order(3)
    @CsvSource({"5, 3, 2", "-5, -3, -2", "-5, 3, -8", "0, 5, -5", "10, 0, 10"})
    void testSubtract(double firstValue, double secondValue, double expectedResult)
    {
        calculator.Subtract(firstValue,secondValue);
        calculator.getResult();
        System.out.println("Result: " + calculator.getResult());
        assertEquals(expectedResult, calculator.getResult());
    }

    @ParameterizedTest
    @Order(4)
    @DisplayName("Multiply test with valid input data")
    @CsvSource({"5, 3, 15", "-5, -3, -15", "-5, 3, -15", "0, 5, 0", "10, 0, 0"})
    void testMultiply(double firstValue, double secondValue, double expectedResult)
    {
        calculator.Multiply(5,3);
        calculator.getResult();
        System.out.println("Result: " + calculator.getResult());
        assertEquals(15, calculator.getResult());
    }

    @ParameterizedTest
    @DisplayName("Division test with valid input data")
    @Order(5)
    @CsvSource({"15, 3, 5", "-15, -3, 5", "-15, 3, -5", "0, 5, 0"})
    void testDivisionPositive(double firstValue, double secondValue, double expectedResult)
    {
        calculator.Division(5,5);
        calculator.getResult();
        System.out.println("Result: " + calculator.getResult());
        assertEquals(1, calculator.getResult());
    }

    @Test
    @DisplayName("Division test with boundary value 0: division by 0")
    @Order(6)
    void testDivisionNegative()
    {
        calculator.Division(10,0);
        calculator.getResult();
        System.out.println("Result: " + calculator.getResult());
        assertEquals(0, calculator.getResult());
    }

//-------------------------------------------------------------------------
    @Test
    @Order(7)
    @DisplayName("Test Execution method")
    void testExecuteMethod()
    {
        calculator.setFirstValue(10);
        calculator.setSecondValue(5);

        assertEquals(15, calculator.execute('a'));
        assertEquals(5, calculator.execute('s'));
        assertEquals(2, calculator.execute('d'));
        assertEquals(50, calculator.execute('m'));
        assertEquals(0, calculator.execute('k'));

    }

//-------------------------------------------------------------------------
    @ParameterizedTest
    @DisplayName("Test execute method using Csv Source")
    @Order(8)
    //           firstValue  secondValue  addResult   subResult  divResult  mulResult   invResult
    @CsvSource({" 10.0,          5.0,       15.0,        5.0,       2.0,       50.0,      0.0",
                "-10.0,         -5.0,      -15.0,       -5.0,       2.0,       50.0,      0.0",
                "-10.0,          5.0,       -5.0,      -15.0,      -2.0,      -50.0,      0.0",
                "  0.0,          5.0,        5.0,       -5.0,       0.0,        0.0,      0.0",
                " 10.0,          0.0,       10.0,       10.0,       0.0,        0.0,      0.0"})
    void testExecuteMethodWithCsvSource(float firstValue, float secondValue, float addResult, float subResult, float divResult, float mulResult, float invRes)
    {
        calculator.setFirstValue(firstValue);
        calculator.setSecondValue(secondValue);

        assertEquals(addResult, calculator.execute('a'));
        assertEquals(subResult, calculator.execute('s'));
        assertEquals(divResult, calculator.execute('d'));
        assertEquals(mulResult, calculator.execute('m'));
        System.out.println("Result: " + calculator.execute('k'));
        assertEquals(invRes, calculator.execute('k'));
    }

}