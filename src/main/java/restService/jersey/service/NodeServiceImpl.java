package restService.jersey.service;

import java.util.List;
import org.bson.Document;
import restService.jersey.bean.Node;
import restService.jersey.common.BaseDao;
import restService.jersey.common.BaseServiceImpl;
import restService.jersey.constant.Constant;
import restService.jersey.constant.NodeType;
import restService.jersey.dao.NodeDao;
import restService.jersey.util.IdUtil;

public class NodeServiceImpl extends BaseServiceImpl<Node> implements NodeService{

	private final static NodeServiceImpl nodeService = new NodeServiceImpl();
	
	private NodeDao nodeDao = NodeDao.getNodeDao();
	
	public static NodeServiceImpl getNodeService(){
		return nodeService;
	}
	private NodeServiceImpl(){
		
	}
	@Override
	public BaseDao<Node> getBaseDao() {
		return nodeDao;
	}
	
	@Override
	public String buildRootNode(Node node) {
		String id = IdUtil.getId();
		node.setNodeName(Constant.ROOT_FOLDER_NAME);
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setTag(Constant.ROOT_FOLDER_TAG);
		node.setId(id);
		node.setNodeType(NodeType.ROOT.getTypeCode());
		nodeDao.saveOrUpdate(node);
		return id;
	}
	@Override
	public String newNode(String pId, Node node) {
		String id = IdUtil.getId();
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setId(id);
		node.setNodeType(NodeType.ROOT.getTypeCode());
		node.setFather(pId);
		nodeDao.saveOrUpdate(node);
		return id;
	}
	@Override
	public void deleteNode(String id) {
		nodeDao.deleteById(id);
		List<Node> children = listNodes(id);
		if(!children.isEmpty()){
			children.forEach(child->deleteNode(child.getId()));
		}
	}
	@Override
	public List<Node> listNodes(String pId) {
		return select(new Document("father",pId), Node.class);
	}
	@Override
	public void copyNode(String id, String targetId) {
		
	}
	@Override
	public List<Node> allRootNodes() {
		Node node = new Node();
		node.setNodeType(NodeType.ROOT.getTypeCode());
		return select(node);
	}
	@Override
	public Node getNodeById(String id) {
		Node node = new Node();
		node.setId(id);
		return selectByUnique(node);
	}
	@Override
	public void moveTo(String id, String targetId) {
		Node node = new Node();
		node.setId(id);
		node.setFather(targetId);
		nodeDao.update(node);
	}

	
}
