package jersey;


import org.junit.Test;
import restService.jersey.bean.Node;
import restService.jersey.service.NodeService;
import restService.jersey.service.NodeServiceImpl;
import restService.jersey.util.JsonUtil;


public class DocServiceTest {

	NodeService nodeSetvice = NodeServiceImpl.getNodeService();
	
//	@Test
	public void buildRoot(){
		Node rootFolder = new Node();
		rootFolder.setCreateUser("yliu");
		rootFolder.setUpdateUser("yliu");
		String id =nodeSetvice.buildRootNode(rootFolder);
		System.out.println("添加Id:"+id);
	}
//	@Test
	public void newFolder(){
		String rootId = "cc02b5dc-6c0a-4bbe-9bfc-5fdc8eec01db";
		Node folder = new Node();
		folder.setNodeName("新建文件夹");
		folder.setCreateUser("yliu");
		folder.setUpdateUser("yliu");
		String id =nodeSetvice.newFolder(rootId, folder);
		System.out.println("添加Id:"+id);
	}
	
//	@Test
	public void deleteTest(){
		String rootId = "cc02b5dc-6c0a-4bbe-9bfc-5fdc8eec01db";
		String id = "60fd2e00-4133-4360-956f-c1315c103a87";
		nodeSetvice.deleteNode(rootId, id);
	}
//	@Test
	public void newFileTest(){
		String rootId = "cc02b5dc-6c0a-4bbe-9bfc-5fdc8eec01db";
		String pid = "c6fb1637-2d8c-4c37-9654-c1eaf4987df0";
		Node node = new Node();
		node.setNodeName("linux相关");
		node.setPid(pid);
		nodeSetvice.newFile(rootId, node);
	}
	@Test
	public void selectToTreeTest(){
		String id = "cc02b5dc-6c0a-4bbe-9bfc-5fdc8eec01db";
		Node node = nodeSetvice.selectToTree(id);
		System.out.println(JsonUtil.JavaToJson(node));
	}
}
