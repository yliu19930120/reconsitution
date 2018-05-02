package jersey;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import restService.jersey.bean.User;
import restService.jersey.service.UserServiceImpl;

public class UserServiceTest {

	private final static Logger log =LoggerFactory.getLogger(UserServiceTest.class);
	
	UserServiceImpl userService = UserServiceImpl.getInstence();
	
	@Test
	public void userTest(){
		Bson filter = new Document("account","admin");

			User user = userService.getUser(filter);
			System.out.println(user.getName());

	}
	
	@Test
	public void saveTest(){
		User user = new User();
	}
}
