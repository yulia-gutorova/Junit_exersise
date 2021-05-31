package com.jensen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestCupConstructor {

    Cup cup = new Cup("", 1);
    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Constructor tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("    ---------- Test body ----------");
    }

//---------------------------------------------
    @Test
    //@Disabled
    @Order(1)
    @DisplayName("Constructor: Test that cup has created correct")
    void testObjectCreation() throws Exception {

        cup = new Cup("water", 75.0);

        assertNotNull(cup);
        assertEquals("water", cup.getLiquidType());
        assertEquals(75.0, cup.getPercentFull());
        assertTrue(!cup.isEmpty());
        assertFalse(cup.isFull());
    }

//---------------------------------------------
    @Test
    @Order(2)
    @DisplayName("Constructor: Test that LiquidType can be null and PercentFull can be 0 ")
    void testThatObjectCanNotBeNull()
    {
        cup = new Cup(null, 0) ;

        assertNull(cup.getLiquidType());
        assertTrue(cup.isEmpty());
        assertFalse(cup.isFull());
        assertEquals(null, cup.getLiquidType());
        assertEquals(0, cup.getPercentFull());

        System.out.println("LiquidType: " + cup.getLiquidType());
    }


//---------------------------------------------
   public static Stream<Arguments> dataForConstructor ()
    {
        return Stream.of(Arguments.of("water", 50),
                Arguments.of(null, 50),
                Arguments.of("", 50),
                Arguments.of("water", 0),
                Arguments.of("water", 100),
                Arguments.of("water", -5),
                Arguments.of("water", 200));
    }

    @ParameterizedTest
    @DisplayName("Constructor: Parameterized test")
    @Order(3)
    @MethodSource("dataForConstructor")
    public void testConstructorWithDifferentParameters (String expectedLiquidType, float expectedPercentFull)
    {
        cup = new Cup(expectedLiquidType, expectedPercentFull);

        assertEquals(expectedLiquidType, cup.getLiquidType());
        assertEquals(expectedPercentFull, cup.getPercentFull());

        System.out.println("Expected liquid type: " + expectedLiquidType + " , " + "Actual liquid type: " + cup.getLiquidType());
        System.out.println("Expected percent Full: " + expectedPercentFull + " , " + "Actual percent Full: " + cup.getPercentFull());
    }

//---------------------------------------------
    @ParameterizedTest
    @DisplayName("Using Csv Source")
    @Order(4)
    @CsvSource({"juice, 50",
                "coffee, 30"})
    void testCsvAsSource(String liquidType, float percentFull)
    {
        cup = new Cup(liquidType, percentFull);

        assertEquals(liquidType, cup.getLiquidType());
        assertEquals(percentFull, cup.getPercentFull());

        System.out.println("Expected liquid type: " + liquidType + " , " + "Actual liquid type: " + cup.getLiquidType());
        System.out.println("Expected percent Full: " + liquidType + " , " + "Actual percent Full: " + cup.getPercentFull());
    }

}