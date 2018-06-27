package jersey;


import java.util.List;

import org.junit.Test;
import restService.jersey.bean.Node;
import restService.jersey.constant.NodeType;
import restService.jersey.service.NodeService;
import restService.jersey.service.NodeServiceImpl;
import restService.jersey.util.JsonUtil;



public class DocServiceTest {

	NodeService nodeSetvice = NodeServiceImpl.getNodeService();
	
	@Test
	public void test(){
//		String id = buildRoot();
		String id = "17029dfb-e154-4e17-9d37-9aab235644d5";
		newFolder(id);
		selectById(id);
	}
	
	
	public String buildRoot(){
		Node rootFolder = new Node();
		rootFolder.setCreateUser("yliu");
		rootFolder.setUpdateUser("yliu");
		String id =nodeSetvice.buildRootNode(rootFolder);
		System.out.println("添加Id:"+id);
		return id;
	}
	
	public void newFolder(String pId){
		Node folder = new Node();
		folder.setCreateUser("yliu");
		folder.setUpdateUser("yliu");
		folder.setNodeType(NodeType.FOLDER.getTypeCode());
		String id =nodeSetvice.newNode(pId,folder);
		System.out.println("添加Id:"+id);
	}
	
	public void selectById(String id){
		List<Node> list = nodeSetvice.selectNodesByPid(id);
		System.out.println(JsonUtil.toJson(list));
	}
}
