package com.sample.lib.dao;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksDao extends BaseDao {
    public List<DBObject> showAll() throws UnknownHostException {
        DBCollection bookRegistry = connectTo("BookRegistry");

        DBCursor dbCursor = bookRegistry.find();
        List<DBObject> booksList = new ArrayList<>();

        for (DBObject object : dbCursor)
            booksList.add(object);

        System.out.println(booksList.size() + " ---");
        return booksList;
    }
}
