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
		String id = "4a5afcd0-0e41-46a4-b422-b0369e832d34";
		newFolder(id);
//		selectById("24366406-7da7-4207-a543-9e8515afb363");
		deleteTest(id);
		selectById("9d433bbb-7ae6-4d85-aa7e-3fe51d4eb196");
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
