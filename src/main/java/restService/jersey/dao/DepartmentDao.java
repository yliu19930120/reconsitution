package restService.jersey.dao;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restService.jersey.bean.Department;
import restService.jersey.common.BaseDao;
import restService.jersey.util.MongoUtil;

public class DepartmentDao extends BaseDao<Department>{

    private final  static DepartmentDao departmentDao = new DepartmentDao();
	
	public static DepartmentDao getInstence(){
		return departmentDao;
	}
	
	private DepartmentDao(){
		
	}
	
	@Override
	public String getDbName() {
		return MongoUtil.DB_NAME_DEFAULT;
	}

	@Override
	public String getCollectionName() {
		return "department";
	}

	@Override
	public Bson getUniqueIndex(Department java) {
		return new Document("id",java.getId());
	}

	@Override
	public Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}

}
