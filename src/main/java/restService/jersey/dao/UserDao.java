package restService.jersey.dao;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restService.jersey.bean.User;
import restService.jersey.common.BaseDao;
import restService.jersey.util.MongoUtil;

public class UserDao extends BaseDao<User>{

	private final static UserDao userDao = new UserDao();
	
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
	public Logger getLogger() {

		return LoggerFactory.getLogger(this.getClass());
	}
	
	@Override
	public Bson getUniqueIndex(User java) {
		return new Document("id",java.getId());
	}
}
