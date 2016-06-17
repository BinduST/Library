package com.sample.lib.dao;

import com.mongodb.*;
import com.sample.lib.entities.Student;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BaseDao {
    public boolean findBy(String username, String password) throws UnknownHostException {
        DBCollection user = connectTo("Student");

        List<BasicDBObject> whereQuery = new ArrayList<>();
        BasicDBObject findQuery = new BasicDBObject();
        whereQuery.add(new BasicDBObject("username", username));
        whereQuery.add(new BasicDBObject("password", password));
        findQuery.put("$and", whereQuery);
        DBCursor dbCursor = user.find(findQuery);
        return dbCursor.hasNext();
    }

    public boolean insert(Student student) throws UnknownHostException {
        DBCollection collection = connectTo("Student");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("username", student.getUsername());
        DBCursor dbCursor = collection.find(whereQuery);

        if (dbCursor.hasNext() == false) {
            BasicDBObject insertQuery = new BasicDBObject();
            insertQuery.put("username", student.getUsername());
            insertQuery.put("password", student.getPassword());
            collection.insert(insertQuery);
            return true;
        } else {
            return false;
        }
    }

    public List<DBObject> showAll() throws UnknownHostException {
        DBCollection bookRegistry = connectTo("BookRegistry");

        DBCursor dbCursor = bookRegistry.find();
        List<DBObject> booksList = new ArrayList<>();

        for (DBObject object : dbCursor)
            booksList.add(object);

        System.out.println(booksList.size() + " ---");
        return booksList;
    }

    private DBCollection connectTo(String collection) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("Library");
        return db.getCollection(collection);
    }
}