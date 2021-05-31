package com.jensen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class QuoteTest {

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Quote method tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("         ---------- Test body ----------");
    }
    Lab1 lab = new Lab1();

//-------------------------------------------------------------------------------------------------------
    @Test
    @Order(1)
    @DisplayName("Test the origin quote() method")
    void TestQuote()
    {
        String q = lab.quote();

        assertNotNull(q);
        assertTrue(q.contains("We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein")||
                q.contains("A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare") ||
                q.contains("You must be the change you wish to see in the world. - Mahatma Gandhi") ||
                q.contains("In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.") ||
                q.contains("Choose a job you love, and you will never have to work a day in your life. - Confucius") ||
                q.contains("To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde") ||
                q.contains("Without music, life would be a mistake. - Friedrich Nietzsche") ||
                q.contains("I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams"));
    }


//-------------------------------------------------------------------------------------------------------
    @Test
    @Order(2)
    @DisplayName("Test Switch statement with Random generator")
    void testRandom() {

        int number = lab.getRandomNumber();
        System.out.println("Number: " + number);

        String quote = lab.newQuote(number);

        List<String> quotes = new ArrayList<>();
        quotes.add("We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein");
        quotes.add("A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare");
        quotes.add("You must be the change you wish to see in the world. - Mahatma Gandhi");
        quotes.add("In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.");
        quotes.add("Choose a job you love, and you will never have to work a day in your life. - Confucius");
        quotes.add("To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde");
        quotes.add("Without music, life would be a mistake. - Friedrich Nietzsche");
        quotes.add("I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams");

        System.out.println("List: " + quotes.get(number - 1));

        assertEquals(quotes.get(number - 1), lab.newQuote(number));
    }
}

