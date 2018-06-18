package restService.jersey.service;


import restService.jersey.bean.File;
import restService.jersey.bean.Folder;
import restService.jersey.bean.Node;
import restService.jersey.bean.RootNode;
import restService.jersey.common.BaseService;

public interface NodeService extends BaseService<Node>{

	public void buildRoorFolder(RootNode root);
	
	public void newFolder(String rootId,Folder folder);
	
	public void newFile(String rootId,File file);

}
