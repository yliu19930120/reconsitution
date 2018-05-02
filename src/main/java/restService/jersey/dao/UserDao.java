package restService.jersey.dao;

import org.bson.Document;
import org.bson.codecs.DoubleCodec;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoCollection;

import restService.jersey.bean.User;
import restService.jersey.common.BaseDao;
import restService.jersey.util.JsonUtil;
import restService.jersey.util.MongoUtil;

public class UserDao extends BaseDao{

	private static UserDao userDao = new UserDao();
	private MongoCollection<Document> collection = MongoUtil.getCollection(getDbName(), getCollectionName());
	public static UserDao getInstence(){
		return userDao;
	}
	private UserDao(){}
	@Override
	public String getDbName() {

		return MongoUtil.DB_NAME_DEFAULT;
	}

	@Override
	public String getCollectionName() {

		return "user";
	}

	@Override
	public Bson getUniqueIndex() {

		return new Document();
	}

	@Override
	public Logger getLogger() {

		return LoggerFactory.getLogger(this.getClass());
	}

	public User getUser(Bson filter){
		
		User user = MongoUtil.adaptToJava(collection.find(filter,Document.class).first(), User.class);
		return user;
	}
	
	public void save(User user){
		Document doc = Document.parse(JsonUtil.getGson().toJson(user));
		collection.insertOne(doc);
	}
}
