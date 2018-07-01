package restService.jersey.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import restService.jersey.bean.Node;
import restService.jersey.constant.Constant;
import restService.jersey.constant.NodeType;
import restService.jersey.dao.NodeDao;
import restService.jersey.util.IdUtil;

public class NodeServiceImpl implements NodeService{

	private final static NodeServiceImpl nodeService = new NodeServiceImpl();
	
	private NodeDao nodeDao = NodeDao.getNodeDao();
	
	public static NodeServiceImpl getNodeService(){
		return nodeService;
	}
	
	private NodeServiceImpl() {
	}
	@Override
	public void saveOrUpdate(Node java) {
		nodeDao.saveOrUpdate(java);
	}

	@Override
	public void saveMany(List<Node> list) {
		nodeDao.saveMany(list);
		
	}

	@Override
	public void deleteByUnique(Node java) {
		nodeDao.deleteByUnique(java);
		
	}

	@Override
	public Node selectByUnique(Node java) {
		return nodeDao.selectByUnique(java, Node.class);
	}

	@Override
	public List<Node> select(Node filter, Bson sort) {
		
		return nodeDao.select(filter, sort, Node.class);
	}

	@Override
	public List<Node> select(Node filter) {
		return nodeDao.select(filter, Node.class);
	}

	@Override
	public List<Node> select(Bson filter, Bson sort) {
		return nodeDao.select(filter, sort,Node.class);
	}

	@Override
	public List<Node> select(Bson filter) {
		
		return nodeDao.select(filter, Node.class);
	}

	@Override
	public Node selectOne(Node filter) {
		
		return nodeDao.selectOne(filter, Node.class);
	}

	@Override
	public Node selectOne(Bson filter) {

		return nodeDao.selectOne(filter, Node.class);
	}


	@Override
	public String buildRootNode(Node node) {
		String id = IdUtil.getId();
		node.setNodeName(Constant.ROOT_FOLDER_NAME);
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setTag(Constant.ROOT_FOLDER_TAG);
		node.setId(id);
		node.setNodeType(NodeType.ROOT.getTypeCode());
		node.setPath(Constant.DEFAULT_PLACE);
		nodeDao.saveOrUpdate(node);
		return id;
	}

	@Override
	public String newNode(String pId,Node node) {
		String id = IdUtil.getId();
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setTag(Constant.DEFAULT_PLACE);
		node.setId(id);
		node.setNodeType(NodeType.FOLDER.getTypeCode());
		node.setPath(Constant.DEFAULT_PLACE);
		
		Node fatherNode = selectById(pId);
		String childId = fatherNode.getFirstChild();
		//如果没有子节点，添加子节点
		if(childId==null){
			nodeDao.setChild(pId, id);
		}else {
			String lastNodeId = null;
			Node childNode = selectById(childId);
			String nextBrotherId = childNode.getNextBrother();
			if(nextBrotherId==null){
				lastNodeId = childNode.getId();
			}else{
				while(nextBrotherId!=null){
					Node nextBrothrer = selectById(nextBrotherId);
					nextBrotherId = nextBrothrer.getNextBrother();
					lastNodeId = nextBrothrer.getId();
				}
			}

			nodeDao.setNextBrother(lastNodeId, id);
		}
		nodeDao.save(node);
		return id;
	}
	public Node selectById(String id){

		return nodeDao.selectById(id);
	}

	@Override
	public void deleteNode(String id) {
			Node node = selectById(id);
			String nextId = node.getNextBrother();
			nodeDao.setChild(new Document("firstChild",id), nextId);
			nodeDao.setNextBrother(new Document("nextBrother",id), nextId);
			recursionDelete(id);
	}


	private void recursionDelete(String id) {
			List<Node> brothers = listNodes(id);
			nodeDao.deleteById(id);
			brothers.forEach(bro->{
						recursionDelete(bro.getId());
			});
	}
	@Override
	public List<Node> listNodes(String pId){
		Node child = nodeDao.getChild(pId);
		List<Node> brothers = new ArrayList<>();
		if(child!=null){
			brothers.add(child);
			Node brother = nodeDao.getNextBrother(child.getId());
			while(brother!=null) {
				brothers.add(brother);
				brother = nodeDao.getNextBrother(brother.getId());
			}
		}
		return brothers;
	}


	@Override
	public void copyNode(String id, String targetId) {
		Node node = selectById(id);
		List<Node> brothers = listNodes(id);
		targetId = copyNode(node, targetId);
		for (Node bro : brothers) {
			copyNode(bro.getId(), targetId);
		}
	}
	private String copyNode(Node node,String targetId) {
		node.setId(IdUtil.getId());
		newNode(targetId, node);
		return node.getId();
	}
}
