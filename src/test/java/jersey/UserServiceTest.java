package jersey;

import org.junit.Test;

import restService.jersey.bean.User;
import restService.jersey.common.factory.ServiceFactory;
import restService.jersey.service.UserService;

public class UserServiceTest {
	
   private UserService userService = ServiceFactory.getUserService();
   
//   @Test
   public void registerTest(){
	   User user = userService.register(getUser());
	   System.out.println("rootNode"+user.getRootNode());
   }
   
   @Test
   public void loginTest(){
	   User user = userService.login(getUser());
	   System.out.println("rootNode"+user.getRootNode());
   }
   
   private User getUser(){
	   User user = new User();
	   user.setName("刘永华");
	   user.setAccount("soinbbzn");
	   user.setPassword("5716597al");
	   user.setCreateUser("admin");
	   return user;
   }
}
