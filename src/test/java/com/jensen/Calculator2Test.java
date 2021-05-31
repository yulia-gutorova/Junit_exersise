package com.jensen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class Calculator2Test {

    Lab1 lab = new Lab1();
    int resCounter;

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Calculator2 class tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("    ---------- Test body ----------");
    }

//-------------------------------------------------------------------------
    @ParameterizedTest
    //@Disabled
    @DisplayName("Test calculator2 using Csv Source")
    @Order(1)
    //           firstValue  secondValue  addResult   subResult  divResult  mulResult
    @CsvSource({" 10,          5,           15,           5,       2,         50",
                "-10,         -5,          -15,          -5,       2,         50",
                "-10,          5,           -5,         -15,      -2,        -50",
                "  0,          5,            5,          -5,       0,          0",
                })

    void testExecuteMethodWithCsvSource(int firstValue, int secondValue, int addResult, int subResult, int divResult, int mulResult)
    {
       assertAll( "All calculators operations:",
               () -> {assertEquals(addResult, lab.add(firstValue, secondValue)); System.out.println("Add counter" + lab.getCounter());},
               () -> {assertEquals(subResult, lab.subtract(firstValue, secondValue)); System.out.println("Sub counter" + lab.getCounter());},
               () -> {assertEquals(divResult, lab.divide(firstValue, secondValue)); System.out.println("Div counter" + lab.getCounter());},
               () -> {assertEquals(mulResult, lab.multiply(firstValue, secondValue)); resCounter = lab.getCounter(); System.out.println("Mul counter" + lab.getCounter());}
               );
        System.out.println("Res counter" + lab.getCounter());
        int callCounter = lab.getCounter();
    }

//-------------------------------------------------------------------------
    @Test
    //@Disabled
    @Order(2)
    @DisplayName("Negative test: division by zero")
    void testDivisionByZero()
    {
        assertThrows(ArithmeticException.class, () ->
        {
            lab.divide(10,0);

        });
        System.out.println("Counter: " + lab.getCounter());
    }

//-------------------------------------------------------------------------
    @ParameterizedTest
    //@Disabled
    @Order(3)
    @DisplayName("Test reverse method with normal string")
    @CsvSource({"-abc- , -cba-"})
    void testReverseNormalString(String stringInput, String reverse)
    {
        assertEquals(reverse, lab.reverse(stringInput));
        System.out.println("Counter: " + lab.getCounter());
    }

//-------------------------------------------------------------------------
    @ParameterizedTest
    //@Disabled
    @Order(4)
    @DisplayName("Test reverse method with empty string")
    @EmptySource
    void testReverse(String stringInput)
    {
        assertEquals("", lab.reverse(stringInput));
        System.out.println("Counter: " + lab.getCounter());
    }

//-------------------------------------------------------------------------
    @ParameterizedTest
    //@Disabled
    @Order(5)
    @DisplayName("Negative test: reverse method with null string")
    @NullSource
    void testReverseNullString(String stringInput)
    {
        assertThrows(NullPointerException.class,
                () ->
                {
                    lab.reverse(stringInput);
                });
        System.out.println("Counter: " + lab.getCounter());
    }


}