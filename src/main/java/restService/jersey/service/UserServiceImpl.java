package restService.jersey.service;

import java.util.List;

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
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public void deleteByUnique(User java) {
		userDao.deleteByUnique(java);
		
	}

	@Override
	public User selectByUnique(User java) {
		return userDao.selectByUnique(java, User.class);
	}

	@Override
	public List<User> select(User filter, Bson sort) {
		return userDao.select(filter, sort, User.class);
	}

	@Override
	public List<User> select(User filter) {
		return userDao.select(filter, User.class);
	}

	@Override
	public User selectOne(User filter) {
		return userDao.selectOne(filter, User.class);
	}

	@Override
	public List<User> select(Bson filter, Bson sort) {
		return userDao.select(filter,sort,User.class);
	}

	@Override
	public List<User> select(Bson filter) {
		return userDao.select(filter, User.class);
	}


	@Override
	public User selectOne(Bson filter) {
		return userDao.selectOne(filter, User.class);
	}

	@Override
	public void saveMany(List<User> list) {
		userDao.saveMany(list);
	}

}
