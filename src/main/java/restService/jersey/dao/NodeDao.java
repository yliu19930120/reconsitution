package restService.jersey.dao;

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
	/**
	 * 添加子节点
	 * @param pId 父节点Id
	 * @param id  添加的子节点Id
	 */
	public void setChild(String pId,String id){
		log.info("向节点:{}添加子节点:{}",pId,id);
		getCollection().updateOne(new Document("id",pId),
				new Document("$set",new Document("firstChild",id)));
	}
	/**
	 * 
	 * @param id 
	 * @param nextBrotherId 下一个兄弟节点Id
	 */
	public void setNextBrother(String id,String nextBrotherId){
		log.info("向节点:{}添加下一个兄弟节点:{}",id,nextBrotherId);
		getCollection().updateOne(new Document("id",id),
				new Document("$set",new Document("nextBrother",nextBrotherId)));
	}
}
