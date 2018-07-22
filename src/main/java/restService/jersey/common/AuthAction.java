package restService.jersey.common;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

import restService.jersey.auth.AuthConstant;
import restService.jersey.constant.StatusCode;

public class AuthAction extends BaseAction implements ContainerRequestFilter {
	

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String token = requestContext.getHeaders().getFirst("token");
		String url = requestContext.getUriInfo().getPath();
		if(!auth(url)&&!(token!=null&&getToken()!=null&&token.equals(getToken()))){
			requestContext.abortWith(Response.ok(R.noLogin())
					.status(StatusCode.NOT_LOGIN.getCode()).build());
		}
	}
	
	private boolean auth(String url){
		for(String reg:AuthConstant.NO_LOGIN_URLS){
			Pattern r = Pattern.compile(reg);
			Matcher m = r.matcher(url);
			if(m.matches()){
				return true;
			}
		}
		return false;
	}

}
