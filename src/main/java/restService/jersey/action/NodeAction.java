package restService.jersey.action;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restService.jersey.bean.Node;
import restService.jersey.common.R;
import restService.jersey.service.NodeService;
import restService.jersey.service.NodeServiceImpl;
import restService.jersey.util.JsonUtil;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/node")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NodeAction {

	private static Logger log = LoggerFactory.getLogger(NodeAction.class);

	NodeService nodeSetvice = NodeServiceImpl.getNodeService();

	@GET
	@Path("nodes/{pId}")
	public String getNodes(@PathParam("pId") String pId) {
		log.info("查询目录id:{}", pId);
		List<Node> list = nodeSetvice.allRootNodes();
		if(!"all".equals(pId)){
			list = nodeSetvice.listNodes(pId);
		}
		return R.ok().put("nodes", list).toJson();
	}

	@POST
	@Path("buildRoot")
	public String getIt() {
		String id = nodeSetvice.buildRootNode(new Node());
		log.info("添加根目录id:{}", id);
		return R.ok().put("id", id).toJson();
	}

	@POST
	@Path("newNode/{pId}")
	public String newFile(@PathParam("pId") String pId, String json) {
		Node node = JsonUtil.toJava(json, Node.class);
		String id = nodeSetvice.newNode(pId, node);
		log.info("在根目录:{}新建文件夹:{},文件Id:{}", pId, node.getNodeName(), id);
		return R.ok().put("id", id).toJson();
	}

	@POST
	@Path("deleteNode/{pId}")
	public String deleteNode(@PathParam("pId") String pId) {
		log.info("删除文件:{}",pId);
		nodeSetvice.deleteNode(pId);
		return R.ok().toJson();
	}
	@POST
	@Path("copyNode/{targetId}")
	public String copyNode(@PathParam("targetId") String targetId,String id){
		log.info("复制文件:{}到目录:{}",id,targetId);
		nodeSetvice.copyNode(id, targetId);
		return R.ok().toJson();
	}
}
