package restService.jersey.service;

import restService.jersey.bean.User;
import restService.jersey.common.BaseService;

public interface UserService extends BaseService<User>{
	
	public User login(User user);
	
	public User register(User user);
	
}
