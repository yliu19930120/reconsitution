package restService.jersey.util;


import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
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
	
	public static final String DB_NAME_DEFAULT="credit";

	private static final String DB_HOST="127.0.0.1";

	private static MongoClient mongoClient=new MongoClient( DB_HOST );
	
	public static MongoCollection<Document> getCollection( String dbName, String collName ) {
		MongoDatabase database=mongoClient.getDatabase( dbName );
		MongoCollection<Document> collection=database.getCollection( collName );
		return collection.withWriteConcern( WriteConcern.W1 );
	}

	public static <T> T adaptToJava( Document t, Class<T> classOfT ) {
		Gson gson=JsonUtil.getGson();
		String json=gson.toJson( t );
		
		return gson.fromJson( json, classOfT );
	}
	
	public static <T> T adaptToJava( Document t, Class<T> classOfT, Gson gson ) {
		
		String json=gson.toJson( t );
		return gson.fromJson( json, classOfT );
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
