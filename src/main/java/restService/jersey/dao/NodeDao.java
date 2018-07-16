package restService.jersey.dao;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restService.jersey.bean.Node;
import restService.jersey.common.BaseDao;
import restService.jersey.util.MongoUtil;

public class NodeDao extends BaseDao<Node>{

	private final static Logger log = LoggerFactory.getLogger(NodeDao.class);
	
	private final static NodeDao nodeDao = new NodeDao();
	
	public static NodeDao getNodeDao(){
		return nodeDao;
	}
	private  NodeDao() {

	}
	@Override
	public String getDbName() {
		return MongoUtil.DB_NAME_DEFAULT;
	}

	@Override
	public String getCollectionName() {
		return "Node";
	}

	@Override
	public Bson getUniqueIndex(Node java) {
		return new Document("id",java.getId());
	}

	@Override
	public Logger getLogger() {
		return log;
	}

	public void deleteById(String id) {
		log.info("删除节点:{}",id);
		getCollection().deleteOne(new Document("id",id));
	}
}
