package com.sample.lib.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.sample.lib.entities.Book;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;

import static com.sample.lib.dao.DBConstants.COLLECTION_BOOK_REGISTRY;

@Repository
public class StudentDao extends BaseDao {
    public Book get(String bookName) throws UnknownHostException {
        DBCollection bookRegistry = connectTo(COLLECTION_BOOK_REGISTRY);
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("book_name", bookName);
        DBCursor cursor = bookRegistry.find(whereQuery);
        return new Book();
    }
}
