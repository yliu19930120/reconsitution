package restService.jersey.common;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import restService.jersey.bean.User;


public class BaseAction{
	
	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;
		
	public User getLoginUser(){
		return (User)request.getSession().getAttribute("loginUser");
	}
	public void setLoginUser(User user){
		request.getSession().setAttribute("loginUser", user);
	}
	public void removeUser(){
		request.getSession().removeAttribute("loginUser");
	}
	
}
