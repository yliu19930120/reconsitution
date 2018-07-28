package restService.jersey.common.factory;

import restService.jersey.service.NodeService;
import restService.jersey.service.NodeServiceImpl;
import restService.jersey.service.UserService;
import restService.jersey.service.UserServiceImpl;

public class ServiceFactory {
	
	public static UserService getUserService(){
		return UserServiceImpl.getInstance();
	}
	
	public static NodeService getNodeService(){
		return NodeServiceImpl.getInstance();
	}
}
