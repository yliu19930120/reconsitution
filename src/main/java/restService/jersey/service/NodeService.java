package restService.jersey.service;



import restService.jersey.bean.Node;
import restService.jersey.common.BaseService;

public interface NodeService extends BaseService<Node>{

	public String buildRootNode(Node node);
	
	public String newFolder(String rootId,Node node);
	
	public String newFile(String rootId,Node node);
	
	public void deleteNode(String rootId,String id);
	
	public Node selectToTree(String id);
}
