package com.jensen;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class BookTest {

    Book book = new Book("", 0, "");

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Book class tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println(" ---------- Test body ----------");
    }

//-------------------------------------------------------------------------

    @Test
    @DisplayName("Test that object Book is created correctly with constructor")
    @Order(1)
    void testThatBookIsCreatedWithConstructor()
    {
        book = new Book ("Lessons Learned", 286, "C. Kaner");

        assertNotNull(book);
        assertEquals("Lessons Learned", book.getTitle());
        assertEquals(286, book.getPages());
        assertEquals("C. Kaner", book.getAuthor());
    }

//-------------------------------------------------------------------------

    @Test
    @DisplayName("Test that object Book is created correctly with setters")
    @Order(2)
    void testThatBookIsCreatedWithSetters()
    {
        book.setTitle("Software Testing Techniques");
        book.setPages(400);
        book.setAuthor("B. Beizer");

        assertNotNull(book);
        assertEquals("Software Testing Techniques", book.getTitle());
        assertEquals(400, book.getPages());
        assertEquals("B. Beizer", book.getAuthor());
    }

//-------------------------------------------------------------------------

    @Test
    @DisplayName("Test that we can not assign null to Title")
    @Order(3)
    void testSetTitleNull ()
    {
        book = new Book ("The Art of Software Testing", 300, "J. Glenford");
        book.setTitle(null);

        assertEquals("The Art of Software Testing", book.getTitle());
    }

//-------------------------------------------------------------------------

    @Test
    @DisplayName("Test that Title cannot be empty")
    @Order(4)
    void testTitleCanNotBeEmpty ()
    {
        book = new Book ("", 300, "R. Patton");

        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                {
                    book.setTitle("");
                }
        );
        assertTrue(exception.getMessage().contains("Title most include characters"));
    }
//-------------------------------------------------------------------------

    @Test
    @DisplayName("Test that number of pages can be 0")
    @Order(5)
    void testPagesCanBeZero ()
    {
        book = new Book ("The Art of Software Testing", 300, "J. Glenford");
        book.setPages(0);

        assertEquals(0, book.getPages());
    }
//-------------------------------------------------------------------------

    @Test
    @DisplayName("Test that number of pages cannot be negative")
    @Order(6)
    void testPagesCanNorBeNegative ()
    {
        book = new Book ("Software Testing", 300, "R. Patton");

        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                {
                    book.setPages(-10);
                }
        );
        assertTrue(exception.getMessage().contains("Pages can´t be negative"));
    }

}//end BookTest