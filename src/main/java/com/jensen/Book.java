package com.jensen;

public class Book {

        private String title;
        private Integer pages;
        private String author;


//----------------- Constructor --------------------------------

        public Book(String title, Integer pages, String author)
        {
            this.title = title;
            this.pages = pages;
            this.author = author;
        }

//--------------------- Setters ---------------------------------
        public void setTitle(String title)
        {
            if(title == null) {
                return;
            }
            if(title.length() ==0 ) {
                throw new IllegalArgumentException("Title most include characters");
            }
            this.title = title;
        }

         public void setPages(Integer pages)
         {
        if(pages < 0) {
            throw new IllegalArgumentException("Pages can´t be negative");
                     }
        this.pages = pages;
         }

        public void setAuthor(String author) {
        this.author = author;
    }

/*
    @Test
    public void testPagesNotEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                {
                    myBook.setPages(0);
                }
        );
        assertTrue(exception.getMessage().contains("Pages can not be zero"));
*/


//------------------- Getters ------------------------------------------
        public Integer getPages() {return pages;}

        public String getTitle() {return title;}

        public String getAuthor() {return author;}


}

