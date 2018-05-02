package restService.jersey.common;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;

import com.mongodb.client.MongoCollection;

import restService.jersey.util.MongoUtil;

public abstract class BaseDao {

	public abstract String getDbName() ;
	
	public abstract String getCollectionName() ;
	
	public abstract Bson getUniqueIndex();
	
	public abstract Logger getLogger();
	
	public MongoCollection getCollection() {
		MongoCollection<Document> collection = MongoUtil.getCollection(getDbName(), getCollectionName());
		return collection;
	}
	
}
