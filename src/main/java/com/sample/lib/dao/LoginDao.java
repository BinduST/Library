package com.sample.lib.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginDao extends BaseDao {
    public boolean authenticate(String username, String password) throws UnknownHostException {
        DBCollection user = connectTo("Student");

        List<BasicDBObject> whereQuery = new ArrayList<>();
        BasicDBObject findQuery = new BasicDBObject();
        whereQuery.add(new BasicDBObject("username", username));
        whereQuery.add(new BasicDBObject("password", password));
        findQuery.put("$and", whereQuery);
        DBCursor dbCursor = user.find(findQuery);
        return dbCursor.hasNext();
    }
}
