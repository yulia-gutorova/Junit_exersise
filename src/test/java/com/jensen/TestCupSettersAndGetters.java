package com.jensen;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestCupSettersAndGetters {

    Cup cup = new Cup("", 0);

//---------------------------------------------
    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Getters and Setters tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("    ---------- Test body ----------");
    }

    @Test
    @Order(1)
    @DisplayName("Happy flow")
    void testAllowableValues()
    {
        cup.setLiquidType("coffee");
        cup.setPercentFull(50);

        assertEquals("coffee", cup.getLiquidType());
        assertEquals(50, cup.getPercentFull());
    }

//---------------------------------------------
    @Test
    //@Disabled
    @Order(2)
    @DisplayName("Setters: Test that PercentFull cannot be less then 0")
    void testThatPercentFullCanNotBeLessThen0 ()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                {
                    cup.setPercentFull(-1);
                }
        );
        assertTrue(exception.getMessage().contains("Percent must be >=0 and <= 100"));
    }

//---------------------------------------------
    @Test
    //@Disabled
    @Order(3)
    @DisplayName("Setters: Test that PercentFull cannot greater then 100")
    void testThatPercentFullCanNotBeGreaterThen100 ()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                {
                    cup.setPercentFull(101);
                }
        );
        assertTrue(exception.getMessage().contains("Percent must be >=0 and <= 100"));
    }

//---------------------------------------------
    @Test
    @Order(4)
    @DisplayName("Setters: Test that liquid type cannot be null")
    void testThatLiquidTypeCannotBeChangedToNull ()
    {
        cup.setLiquidType("water");
        cup.setLiquidType(null);

        assertEquals("water", cup.getLiquidType());
    }

}
