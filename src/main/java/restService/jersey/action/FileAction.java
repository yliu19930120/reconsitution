package restService.jersey.action;



import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import restService.jersey.common.AuthAction;

@Path("/file")
public class FileAction extends AuthAction{
	
	private final static Logger log = LoggerFactory.getLogger(FileAction.class);
	
	@GET
	@Path("/download")
	public Response downloald(){
		String hello = "helloworld";
		byte[] b = hello.getBytes();
		Response rep = Response.ok(new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                output.write(b);
            }
        }).header("Content-disposition", "attachment;filename=hello.txt")
                .header("Cache-Control", "no-cache").status(200).build();
		return rep;
	}
}
