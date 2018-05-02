package restService.jersey.action;


import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restService.jersey.mycol.MycolDao;
import restService.jersey.util.JsonUtil;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
@Produces("application/json")
public class MyResource {
	
	private static Logger log = LoggerFactory.getLogger(MyResource.class);
	
//	private static MycolDao mycolDao = new MycolDao();

    @GET
    @Path("/getName")
    public String getIt() {
    	Map<String,Object> map = new HashMap<>();
    	map.put("UserName", "刘永华");
       return JsonUtil.getGson().toJson(map);
    }
    
    @POST
    @Path("/{id}/getWord")
    public String getWord(@PathParam("id") String id) {
    	Map<String,Object> map = new HashMap<>();
    	map.put("Word", "nihao");
       return JsonUtil.getGson().toJson(map);
    }
}
