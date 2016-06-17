package com.sample.lib.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void shouldHaveFixedDigitsOfIsbn() throws Exception {
        int isbn = 100;
        String author = "Shakespeare";
        String name = "Othello";
        String publisher = "Oxford";
        double price = 500;
        Book book = new Book(isbn, name, author, publisher, price);
        int actual = (int) Math.log10(book.getIsbn()) + 1;
        assertEquals(3, actual, 0);
    }
}