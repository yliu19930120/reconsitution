package jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.junit.Test;




public class MyResourcTest {
	

	
	private String serverUri = "http://localhost:8080/jersey/webapi/";
	
//	@Test  
    public void test() {  
  
        Client client = ClientBuilder.newClient();  
        WebTarget target = client.target(serverUri + "myresource/getName");  
        Response response = target.request()  
                                  .buildGet()  
                                  .invoke();  
        String readEntity = response.readEntity(String.class);  
        System.out.println(readEntity);  
        response.close();  
    }  
    
	@Test  
    public void buildRootTest() {  
  
        Client client = ClientBuilder.newClient();  
        WebTarget target = client.target(serverUri + "node/buildRoot");  
        Response response = target.request()  
                                  .buildPost(null)
                                  .invoke();  
        String readEntity = response.readEntity(String.class);  
        System.out.println(readEntity);  
        response.close();  
    } 
}
