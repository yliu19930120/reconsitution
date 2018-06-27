package restService.jersey.service;



import java.util.List;

import restService.jersey.bean.Node;
import restService.jersey.common.BaseService;

public interface NodeService extends BaseService<Node>{

	public String buildRootNode(Node node);
	
	public String newNode(String pId,Node node);
	
	public void deleteNode(String pId,String id);
	
	public List<Node> selectNodesByPid(String pId);
}
