package restService.jersey.dao;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restService.jersey.bean.Role;
import restService.jersey.common.BaseDao;
import restService.jersey.util.MongoUtil;

public class RoleDao extends BaseDao<Role>{
	
	private final static RoleDao roleDao = new RoleDao();
	
	public static RoleDao getInstance(){
		return roleDao;
	}

	private RoleDao(){
		
	}
	
	@Override
	public String getDbName() {
		return MongoUtil.DB_NAME_DEFAULT;
	}

	@Override
	public String getCollectionName() {
		return "role";
	}

	@Override
	public Bson getUniqueIndex(Role java) {
		return new Document("id",java.getId());
	}

	@Override
	public Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}

}
