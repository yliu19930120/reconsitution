package restService.jersey.service;


import org.bson.Document;
import restService.jersey.bean.Node;
import restService.jersey.bean.User;
import restService.jersey.common.BaseDao;
import restService.jersey.common.BaseServiceImpl;
import restService.jersey.common.ServiceFactory;
import restService.jersey.dao.UserDao;
import restService.jersey.tools.MD5;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	private final static UserServiceImpl userService = new UserServiceImpl();
	
	private UserDao userDao = UserDao.getUserDao();
	
	public static UserServiceImpl getUserService(){
		return userService;
	}
	
	private UserServiceImpl() {
	}

	@Override
	public BaseDao<User> getBaseDao() {
		return userDao;
	}


	@Override
	public User login(User user) {
		Document filter = new Document("account",user.getAccount())
				.append("password", MD5.encryption(user.getPassword()));
		User resUser = selectOne(filter,User.class);
		return resUser;
	}

	@Override
	public User register(User user) {
		Node node = new Node();
		node.setCreateUser(user.getId());
		node.setUpdateUser(user.getId());
		NodeService nodeService = ServiceFactory.getNodeService();
		String rootNode = nodeService.buildRootNode(node);
		user.setRootNode(rootNode);
		user.setPassword(MD5.encryption(user.getPassword()));
		saveOrUpdate(user);
		return user;
	}

}
