package restService.jersey.service;

import org.bson.conversions.Bson;

import restService.jersey.bean.User;

public interface UserService {

	
	public User getUser(Bson filter);
	
	public void save(User user);
}
