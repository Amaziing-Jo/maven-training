package fr.dawan.formation.persistence;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoDatabase;

public class BddConnection {

  private static final String hostname = "localhost";
  private static final int port = 27017;
  private static final String dbName = "dawan-formation-db";

  private static MongoClient conn = null;
  private static MongoDatabase db = null;

  public static MongoClient getInstance() throws MongoClientException {
    if(conn == null) {
      try {
        conn = new MongoClient(hostname, port);
      } catch(MongoClientException e) {
        e.printStackTrace();
      }
    }

    return conn;
  }

  public static MongoDatabase getDatabase() {
    MongoClient mongoClient = BddConnection.getInstance();

    try {
      db = mongoClient.getDatabase(dbName);
    } catch(MongoClientException e) {
      e.printStackTrace();
    }

    return db;
  }


}