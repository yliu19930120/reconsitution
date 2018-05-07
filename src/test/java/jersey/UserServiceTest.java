package jersey;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import restService.jersey.bean.User;
import restService.jersey.service.UserServiceImpl;
import restService.jersey.tools.MD5;
import restService.jersey.util.IdUtil;

public class UserServiceTest {

	private final static Logger log =LoggerFactory.getLogger(UserServiceTest.class);
	
	UserServiceImpl userService = UserServiceImpl.getInstence();
	
	@Test
	public void userTest(){
	
		Document filter = new Document("account","admin");
		User user = userService.selectOne(filter);
		System.out.println(user.getName());
	}
	
//	@Test
	public void saveTest(){
		User user = new User();
		user.setAccount("admin");
		user.setCreatDate(new Date());
		user.setCreateUser("admin");
		user.setEmail("yliu19930120@163.com");
		user.setId(IdUtil.getId());
		user.setName("刘永华");
		user.setOrder(1);
		user.setPassword(MD5.encryption("5716597al"));
		user.setPhone("17328700183");
		user.setStatus(0);
		user.setUpdateDate(new Date());
		user.setUpdateUser("admin");
        userService.saveOrUpdate(user);
	}
}
