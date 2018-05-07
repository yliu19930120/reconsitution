package jersey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import restService.jersey.bean.Role;
import restService.jersey.service.RoleService;
import restService.jersey.service.RoleServiceImpl;
import restService.jersey.util.IdUtil;

public class RoleServiceTest {

	RoleService roleService = RoleServiceImpl.getInstence();
	
	@Test
	public void saveTest(){
		Role admin = createRole("admin","管理员",1);
		Role clerk = createRole("clerk","贷审会秘书",1);
		Role examinant = createRole("examinant","审查员",1);
		Role firstTrial = createRole("firstTrial","初审岗",1);
		Role reviewTrial = createRole("reviewTrial","复审岗",1);
		Role manager = createRole("manager","贷后管理岗",1);
		List<Role> roles = new ArrayList<>();
		roles.add(admin);
		roles.add(clerk);
		roles.add(examinant);
		roles.add(firstTrial);
		roles.add(reviewTrial);
		roles.add(manager);
		roleService.saveMany(roles);
	}
	
	private Role createRole(String code,String name,Integer order){
		Role role = new Role();
		role.setCode(code);
		role.setName(name);
		role.setCreateUser("admin");
		role.setId(IdUtil.getId());
		role.setOrder(order);
		role.setStatus(0);
		role.setUpdateDate(new Date());
		role.setUpdateUser("admin");
		role.setCreatDate(new Date());
		role.setCreateUser("admin");
		return role;
	}
}
