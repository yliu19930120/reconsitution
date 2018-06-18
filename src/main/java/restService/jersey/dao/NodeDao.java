package restService.jersey.dao;

import java.util.Date;

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

	
	public Document selectById(String id){
		Bson filter = new Document("id",id);
		Document doc = getCollection().find(filter).first();
		return doc;
	}
	
	public void addNode(String rootId,Node java){
		java.setCreatDate(new Date());
		java.setUpdateDate(new Date());
		java.setStatus(Node.IN_USE);
		Bson filter = new Document("id",rootId);
		Bson updateDoc = new Document("$push",new Document("children",MongoUtil.adaptToDocuemnt(java)));
		log.info("向表:{}更新{},更新条件{}",getCollectionName(),updateDoc,filter);
		getCollection().updateOne(filter, updateDoc);
	}
}
