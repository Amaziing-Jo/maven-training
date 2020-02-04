package fr.dawan.persistence;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.UnixServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import fr.dawan.entities.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public UserDao(MongoDatabase db) {
        this.db = db;
        this.collection = db.getCollection("user");
    }

    public boolean create(User user) {
//        MongoClient mongoClient = BddConnection.getInstance();
//        MongoDatabase db = mongoClient.getDatabase("dawan-formation-db");
//        MongoDatabase db = BddConnection.getDatabase();

//        MongoCollection<Document> collection = db.getCollection("user");

        Document doc = new Document("firstName", user.getPrenom())
                .append("lastName", user.getNom());

        try {
            collection.insertOne(doc);
            return true;
        } catch(MongoClientException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<User> findAllUsers() {
//        MongoClient mongoClient = BddConnection.getInstance();
//        MongoDatabase db = mongoClient.getDatabase("dawan-formation-db");

//        MongoCollection<Document> collection = db.getCollection("user");

        MongoCursor<Document> cursor = collection.find().iterator();

        List<User> result = new ArrayList<>();

        try {
            while (cursor.hasNext()) {
                Document mDocument = cursor.next();
                System.out.println(mDocument);
                result.add(new User(mDocument.getObjectId("_id").toString(), mDocument.getString("firstName"), mDocument.getString("lastName")));
            }
        } finally {
            cursor.close();
        }

        return result;
    }

    public boolean deleteAll() {
        BasicDBObject document = new BasicDBObject();

        try {
            DeleteResult deleteResult = collection.deleteMany(document);
            return true;
        } catch(MongoClientException e) {
            e.printStackTrace();
        }

        return false;
    }
}