package restService.jersey.service;

import org.bson.conversions.Bson;

import restService.jersey.bean.User;
import restService.jersey.dao.UserDao;

public class UserServiceImpl implements UserService{

	private static UserServiceImpl userService = new UserServiceImpl();
	
	public static UserServiceImpl getInstence(){
		return userService;
	}
	private UserDao userDao = UserDao.getInstence();
	
	private UserServiceImpl() {

	}
	@Override
	public User getUser(Bson filter) {
		
		return userDao.getUser(filter);
	}
	@Override
	public void save(User user) {
		userDao.save(user);
	}

}
