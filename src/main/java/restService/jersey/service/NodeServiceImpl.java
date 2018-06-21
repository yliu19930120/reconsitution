package restService.jersey.service;

import java.util.ArrayList;
import java.util.List;
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
		node.setChildren(new ArrayList<>());
		node.setNodeName(Constant.ROOT_FOLDER_NAME);
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setTag(Constant.ROOT_FOLDER_TAG);
		node.setId(id);
		node.setPid(Constant.TOP_PID);
		node.setNodeType(NodeType.ROOT.getTypeCode());
		node.setPath(Constant.DEFAULT_PLACE);
		nodeDao.saveOrUpdate(node);
		return id;
	}

	@Override
	public String newFolder(String rootId, Node node) {
		String id = IdUtil.getId();
		node.setChildren(new ArrayList<>());
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setTag(Constant.DEFAULT_PLACE);
		node.setId(id);
		node.setNodeType(NodeType.FOLDER.getTypeCode());
		node.setPath(Constant.DEFAULT_PLACE);
		if(node.getPid()==null){
			node.setPid(rootId);
		}
		nodeDao.addNode(rootId, node);
		return id;
	}

	@Override
	public String newFile(String rootId, Node node) {
		String id = IdUtil.getId();
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setTag(Constant.DEFAULT_PLACE);
		node.setId(id);
		node.setNodeType(NodeType.FILE.getTypeCode());
		node.setPath(Constant.DEFAULT_PLACE);
		if(node.getPid()==null){
			node.setPid(rootId);
		}
		nodeDao.addNode(rootId, node);
		return id;
	}

	@Override
	public void deleteNode(String rootId, String id) {
		nodeDao.deleteNode(rootId, id);
	}

	@Override
	public Node selectToTree(String id) {
		Node node = selectById(id);
		return node;
	}
	
	private Node selectById(String id){
		Node node = new Node();
		node.setId(id);
		return nodeDao.selectByUnique(node, Node.class);
	}
}
