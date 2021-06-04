package com.jensen;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@DisplayName("Book java class testing")
class BookTest {

    Book book = new Book("", 0, "");

//-------------------------------------------------------------------------
    @Nested
    @DisplayName("Constructor testing")
    class whenConstructor {

        @Test
        @DisplayName("Test that object Book is created correctly with constructor: Title")
        @Order(1)
        void testThatBookIsCreatedWithConstructorTitle() {
            book = new Book("Lessons Learned", 286, "C. Kaner");
            assertNotNull(book);
            assertEquals("Lessons Learned", book.getTitle());
        }

        @Test
        @DisplayName("Test that object Book is created correctly with constructor: Pages")
        @Order(2)
        void testThatBookIsCreatedWithConstructorPages() {
            book = new Book("Lessons Learned", 286, "C. Kaner");

            assertNotNull(book);
            assertEquals(286, book.getPages());
        }

        @Test
        @DisplayName("Test that object Book is created correctly with constructor: Author")
        @Order(3)
        void testThatBookIsCreatedWithConstructorAuthor() {
            book = new Book("Lessons Learned", 286, "C. Kaner");

            assertNotNull(book);
            assertEquals("C. Kaner", book.getAuthor());
        }
    }

//-------------------------------------------------------------------------

    @Nested
    @DisplayName("Getter/Setter testing with valid values")
    class whenGetterSetter {
        @Test
        @DisplayName("Test that object Book is created correctly with setters: Title")
        @Order(1)
        void testThatBookIsCreatedWithSettersTitle() {
            book.setTitle("Software Testing Techniques");

            assertNotNull(book);
            assertEquals("Software Testing Techniques", book.getTitle());
        }

        @Test
        @DisplayName("Test that object Book is created correctly with setters: Pages")
        @Order(2)
        void testThatBookIsCreatedWithSettersPages() {
            book.setPages(400);

            assertNotNull(book);
            assertEquals(400, book.getPages());
        }

        @Test
        @DisplayName("Test that object Book is created correctly with setters: Author")
        @Order(3)
        void testThatBookIsCreatedWithSettersAuthor() {
            book.setAuthor("B. Beizer");

            assertNotNull(book);
            assertEquals("B. Beizer", book.getAuthor());
        }

        @Test
        @DisplayName("Test that number of pages can be 0")
        @Order(4)
        void testPagesCanBeZero() {
            book.setPages(0);

            assertEquals(0, book.getPages());
        }
    }

//-------------------------------------------------------------------------
    @Nested
    @DisplayName("Getter/Setter testing with invalid values")
    class whenNegativeInput
    {
        @Test
        @DisplayName("Test that we can not assign null to Title")
        @Order(1)
            void testSetTitleNull() {
            book.setTitle("The Art of Software Testing");
            book.setTitle(null);

            assertEquals("The Art of Software Testing", book.getTitle());
        }

        @Test
        @DisplayName("Test that Title cannot be empty")
        @Order(2)
        void testTitleCanNotBeEmpty() {

            Exception exception = assertThrows(IllegalArgumentException.class, () ->
                    {
                        book.setTitle("");
                    }
            );
            assertTrue(exception.getMessage().contains("Title most include characters"));
    }

        @Test
        @DisplayName("Test that number of pages cannot be negative")
        @Order(4)
        void testPagesCanNorBeNegative() {

            Exception exception = assertThrows(IllegalArgumentException.class, () ->
                    {
                        book.setPages(-10);
                    }
            );
            assertTrue(exception.getMessage().contains("Pages can´t be negative"));
        }
}
}//end BookTest