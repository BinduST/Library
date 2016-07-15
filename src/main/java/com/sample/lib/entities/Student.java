/*
Student can take a book from library
 */

package com.sample.lib.entities;

import com.mongodb.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;
import java.net.UnknownHostException;

import static com.sample.lib.dao.DBConstants.COLLECTION_STUDENT;

@Document(collection = COLLECTION_STUDENT)
public class Student {
    @Id
    private String id;

    @Size(min = 2, max = 30)
    @Field
    private String username;

    @Size(min = 2, max = 12)
    @Field
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public boolean take(String bookName) throws UnknownHostException {
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        DB db = mongoClient.getDB("Library");
//        DBCollection collection = db.getCollection("BookRegistry");
//        BasicDBObject whereQuery = new BasicDBObject();
//        whereQuery.put("book_name", bookName);
//        DBCursor cursor = collection.find(whereQuery);
//        return cursor.length() > 0;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}