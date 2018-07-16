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
		String pid = "02009101-fa6a-4f7a-aeef-e476817088b3";
//		String id = buildRoot();
		newFolder(pid);
		listNodes(pid);
	}
	private void listNodes(String id){
		List<Node> list = nodeSetvice.listNodes(id);
		System.out.println(JsonUtil.toJson(list));
	}
	private void update(){
		Node node = new Node();
		node.setNodeName("这是再次修改的文件夹");
		node.setId("1d6a24ad-dfd9-4861-abd1-463198f44a62");
		nodeSetvice.update(node);
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
		List<Node> list = nodeSetvice.listNodes(id);
		System.out.println(JsonUtil.toJson(list));
	}
	
	public void deleteTest(String pId) {
		nodeSetvice.deleteNode(pId);
	}
}
