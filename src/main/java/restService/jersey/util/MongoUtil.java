package restService.jersey.util;



import java.util.Iterator;
import java.util.Map.Entry;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;




/**
 * @author 刘永华
 * Mongo连接池
 *
 */
public class MongoUtil {
	
public static Logger log=LoggerFactory.getLogger( MongoUtil.class );
	
	public static final String DB_NAME_DEFAULT="note";

	private static final String DB_HOST="127.0.0.1";

	private static MongoClient mongoClient=new MongoClient( DB_HOST );
	
	public static MongoCollection<Document> getCollection( String dbName, String collName ) {
		MongoDatabase database=mongoClient.getDatabase( dbName );
		MongoCollection<Document> collection=database.getCollection( collName );
		return collection.withWriteConcern( WriteConcern.W1 );
	}

	public static <T> T adaptToJava( Document t, Class<T> classOfT ) {
		
		return new JSONObject(t).toJavaObject(classOfT);
	}
	
	public static<T> Document adaptToDocuemnt(T java){
		JSONObject json = (JSONObject) JSONObject.toJSON(java);
		Document doc = new Document(json);
		removeNullKey(doc);
		return doc;
	}
	private static void removeNullKey(Document doc){
		Iterator<Entry<String,Object>> it = doc.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,Object> entry = it.next();
			if(entry.getValue()==null){
				it.remove();
			}else if(entry.getValue() instanceof Document){
				removeNullKey((Document)entry.getValue());
			}
		}
	}
	public static DB getDB(String db) {
		return new DB(mongoClient, db);
	}

	public static void close() {
		try {
			mongoClient.close();
		} catch( Exception e ) {}
	}
}
