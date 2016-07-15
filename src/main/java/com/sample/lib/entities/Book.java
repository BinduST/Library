package com.sample.lib.entities;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.sample.lib.dao.DBConstants.COLLECTION_BOOK_REGISTRY;

@Getter
@Document(collection = COLLECTION_BOOK_REGISTRY)
public class Book {
    @Field
    private int isbn;
    @Field
    private String bookName;
    @Field
    private String author;
    @Field
    private String publisher;
    @Field
    private double price;
}
