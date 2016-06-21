package com.sample.lib.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.sample.lib.entities.Student;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;


@Repository
public class SignUpDao extends BaseDao {

    public boolean register(Student student) throws UnknownHostException {
        DBCollection collection = connectTo("Student");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("username", student.getUsername());
        DBCursor dbCursor = collection.find(whereQuery);

        if (!(dbCursor.hasNext())) {
            BasicDBObject insertQuery = new BasicDBObject();
            insertQuery.put("username", student.getUsername());
            insertQuery.put("password", student.getPassword());
            collection.insert(insertQuery);
            return true;
        }
        return false;
    }
}