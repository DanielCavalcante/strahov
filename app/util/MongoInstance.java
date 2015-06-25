package util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoInstance {

	private static MongoInstance instance;
	private MongoClient client;
	private DB db;

	public static MongoInstance getInstance() {
		if (instance == null)
			instance = new MongoInstance();
		return instance;
	}

	private MongoInstance() {
		try {
			client = new MongoClient();
			db = client.getDB("strahov");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public DB getDB() {
		return db;
	}

}
