package jersey;


import org.junit.Test;

import restService.jersey.bean.File;
import restService.jersey.bean.Folder;
import restService.jersey.bean.RootNode;
import restService.jersey.service.NodeService;
import restService.jersey.service.NodeServiceImpl;


public class DocServiceTest {

	NodeService nodeSetvice = NodeServiceImpl.getNodeService();
	
	@Test
	public void buildRoot(){
		RootNode rootFolder = new RootNode();
		rootFolder.setCreateUser("yliu");
		rootFolder.setUpdateUser("yliu");
		nodeSetvice.buildRoorFolder(rootFolder);
	}
//	@Test
	public void addFolder(){
		Folder folder = new Folder();
		folder.setCreateUser("yliu");
		folder.setUpdateUser("yliu");
		folder.setNodeName("新建文件夹");
		String pId = "95206da7-0f60-4c71-b868-d8b9d9010e1d";
		nodeSetvice.newFolder(pId, folder);
	}
//	@Test
	public void addFile(){
		File file = new File();
		file.setCreateUser("yliu");
		file.setUpdateUser("yliu");
		file.setNodeName("无标题文本");
		file.setTag("子文档");
		String pId = "95206da7-0f60-4c71-b868-d8b9d9010e1d";
		nodeSetvice.newFile(pId, file);
	}
	
}
