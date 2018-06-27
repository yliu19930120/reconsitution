package restService.jersey.action;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import restService.jersey.bean.Node;
import restService.jersey.common.R;
import restService.jersey.service.NodeService;
import restService.jersey.service.NodeServiceImpl;
import restService.jersey.util.IdUtil;



/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/node")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NodeAction {
	
	private static Logger log = LoggerFactory.getLogger(NodeAction.class);
	
	NodeService nodeSetvice = NodeServiceImpl.getNodeService();

    @POST
    @Path("buildRoot")
    public String getIt() {
       String id = IdUtil.getId();
       Node root = new Node();
       root.setId(id);
       log.info("添加根目录id:{}",id);
       nodeSetvice.buildRootNode(root);
       return JSON.toJSONString(R.ok().put("id", id));
    }
    
    @POST
    @Path("newFile/{rootId}")
    public String newFile(@PathParam("rootId")String rootId){
    	Node file = new Node();
    	String id = IdUtil.getId();
    	String name = "新建文件夹";
    	file.setId(id);
    	file.setNodeName(name);
    	log.info("在根目录:{}新建文件夹:{},文件Id:{}",rootId,name,id);
//    	nodeSetvice.newFile(rootId, new Node());
    	return JSON.toJSONString(R.ok().put("id", id));
    	}
}
