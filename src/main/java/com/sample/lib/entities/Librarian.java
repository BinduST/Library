/*
    Librarian can add book to library
 */
package com.sample.lib.entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class Librarian {
    private String username;
    private String password;

    public Librarian(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean register(Book book) throws UnknownHostException {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);//connect to db server
            DB db = mongoClient.getDB("Library");//connect to db

            DBCollection collection = db.getCollection("BookRegistry");
            BasicDBObject newBook = new BasicDBObject();

            newBook.put("book_name", book.getBookName());
            newBook.put("author", book.getAuthor());
            newBook.put("publisher", book.getPublisher());
            newBook.put("price", book.getPrice());

            collection.insert(newBook);
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }
}