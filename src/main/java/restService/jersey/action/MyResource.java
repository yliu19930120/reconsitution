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
import com.mongodb.util.JSON;


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
       return JSON.serialize(map);
    }
    
    @POST
    @Path("/{id}/getWord")
    public String getWord(@PathParam("id") String id) {
    	Map<String,Object> map = new HashMap<>();
    	map.put("Word", "nihao");
       return JSON.serialize(map);
    }
}
