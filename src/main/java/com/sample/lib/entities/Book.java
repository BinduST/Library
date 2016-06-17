package com.sample.lib.entities;

public class Book {
    private int isbn;
    private String bookName;
    private String author;
    private String publisher;
    private double price;

    public Book(int isbn, String author, String bookName, String publisher, double price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }
}
