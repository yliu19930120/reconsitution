package restService.jersey.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import restService.jersey.bean.File;
import restService.jersey.bean.Folder;
import restService.jersey.bean.Node;
import restService.jersey.bean.RootNode;
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
	public void buildRoorFolder(RootNode root) {
		root.setNodeName(Constant.ROOT_FOLDER_NAME);
		root.setNodeType(NodeType.ROOT.getTypeCode());
		root.setChildren(new ArrayList<>());
        saveOrUpdate(root);
	}
	
	@Override
	public void newFolder(String rootId, Folder folder) {
		folder.setNodeType(NodeType.FOLDER.getTypeCode());
		folder.setId(IdUtil.getId());
		if(folder.getpId()==null)folder.setpId(rootId);
		nodeDao.addNode(rootId, folder);
	}

	@Override
	public void newFile(String rootId, File file) {
		file.setNodeType(NodeType.FILE.getTypeCode());
		file.setId(IdUtil.getId());
		if(file.getpId()==null)file.setpId(rootId);
		nodeDao.addNode(rootId, file);
	}
	
}
