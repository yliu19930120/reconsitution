package restService.jersey.action;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restService.jersey.bean.User;
import restService.jersey.common.BaseAction;
import restService.jersey.common.R;
import restService.jersey.common.factory.ServiceFactory;
import restService.jersey.constant.StatusCode;
import restService.jersey.service.UserService;
import restService.jersey.util.IdUtil;
import restService.jersey.util.JsonUtil;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserAction extends BaseAction{
	
	private UserService userService = ServiceFactory.getUserService();
	
	@GET
	public String getUser(){
		User user = getLoginUser();
		if(user==null){
			return R.error(StatusCode.NOT_LOGIN.getMsg()).toJson();
		}
		return R.ok().put("user", user).toJson();
	}
	
	@Path("/login")
	@POST
	public String login(String json){
		User user = userService.login(JsonUtil.toJava(json, User.class));
		if(user==null){
			return R.error(StatusCode.FAILED.getMsg()).toJson();
		}else{
			user.setPassword(null);
			setLoginUser(user);
			setToken(IdUtil.tokenId());
		}
		return R.ok()
				.put("user", user).put("token", getToken()).toJson();
	}
	@Path("/logout")
	@POST
	public String logout(){
		removeUser();
		removeToken();
		return R.ok().toJson();
	}
	@Path("/register")
	@POST
	public String register(String json){
		User user = userService.register(JsonUtil.toJava(json, User.class));
		user.setPassword(null);
		setToken(IdUtil.tokenId());
		setLoginUser(user);
		return R.ok().put("user", user)
				.put("user", user).put("token", getToken()).toJson();
	}
}
