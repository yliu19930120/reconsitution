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

import restService.jersey.bean.User;
import restService.jersey.common.AuthAction;

@Path("/file")
public class FileAction extends AuthAction{
	
	private final static Logger log = LoggerFactory.getLogger(FileAction.class);
	
	@GET
	@Path("/download")
	public Response downloald(){
		User user = getLoginUser();
		String hello = "helloworld";
		String fileName = "hello.txt";
		byte[] b = hello.getBytes();
		Response rep = Response.ok(new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                output.write(b);
            }
        }).header("Content-disposition", "attachment;filename="+fileName)
                .header("Cache-Control", "no-cache").status(200).build();
		log.info("{}下载文件{}",user.getId(),fileName);
		return rep;
	}
}
