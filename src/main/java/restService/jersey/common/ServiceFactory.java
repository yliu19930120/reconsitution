package restService.jersey.common;

import restService.jersey.service.NodeService;
import restService.jersey.service.NodeServiceImpl;
import restService.jersey.service.UserService;
import restService.jersey.service.UserServiceImpl;

public class ServiceFactory {
	
	public static UserService getUserService(){
		return UserServiceImpl.getUserService();
	}
	
	public static NodeService getNodeService(){
		return NodeServiceImpl.getNodeService();
	}
}
