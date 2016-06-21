package com.sample.lib.dao;

import com.mongodb.*;
import com.sample.lib.entities.Student;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class BaseDao {
    DBCollection connectTo(String collection) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("Library");
        return db.getCollection(collection);
    }
}