package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class MongoParser {

	public DBObject toDBObject(Object o) {
		BasicDBObject doc = new BasicDBObject();
		for (Field f : o.getClass().getDeclaredFields()) {
			String key = f.getName().equals("id") ? "_id" : f.getName();
			String prefix = f.getType().equals(boolean.class) ? "is" : "get";
			String name = prefix + 
					String.valueOf(f.getName().charAt(0)).toUpperCase() +
					f.getName().substring(1);
			
			try {
				Method m = o.getClass().getDeclaredMethod(name);
				doc.put(key, m.invoke(o, new Object[]{}));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return doc;
	}
	
}
