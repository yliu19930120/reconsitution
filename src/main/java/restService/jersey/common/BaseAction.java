package restService.jersey.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import restService.jersey.bean.User;

public class BaseAction{
	
	@Context
	public HttpServletRequest request;

	@Context
	public HttpServletResponse response;

	public User getLoginUser(){
		return (User)request.getSession().getAttribute("loginUser");
	}
	public void setLoginUser(User user){
		request.getSession().setAttribute("loginUser", user);
	}
	public void removeUser(){
		request.getSession().removeAttribute("loginUser");
	}
	public String getToken(){
		return (String)request.getSession().getAttribute("token");
	}
	public void setToken(String token){
		request.getSession().setAttribute("token", token);
	}
	public void removeToken(){
		request.getSession().removeAttribute("token");
	}
}
