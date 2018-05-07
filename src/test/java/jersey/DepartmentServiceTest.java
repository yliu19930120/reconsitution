package jersey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import restService.jersey.bean.Department;
import restService.jersey.bean.Role;
import restService.jersey.service.DepartmentSeviceImpl;




public class DepartmentServiceTest {

	DepartmentSeviceImpl departmentSevice = DepartmentSeviceImpl.getInstance();
	@Test
	public void saveTest(){
		Department deaprtMent = new Department();
		deaprtMent.setCreatDate(new Date());
		deaprtMent.setCreateUser("admin");
		deaprtMent.setName("交通银行深圳分行");
		deaprtMent.setOrder(1);
		deaprtMent.setStatus(0);
		deaprtMent.setUpdateDate(new Date());
		deaprtMent.setUpdateUser("admin");
		Role role = new Role();
		role.setCode("admin");
		role.setName("管理员");
		role.setCreatDate(new Date());
		role.setCreateUser("admin");
		role.setStatus(0);
		role.setUpdateDate(new Date());
		role.setUpdateUser("admin");
		List<Role> roles = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		role.setUserIds(ids);
		ids.add("d166c4cb-5e9d-4440-ad99-6470d5859e0a");
		roles.add(role);
		Department credit = new Department();
		credit.setCreatDate(new Date());
		credit.setCreateUser("admin");
		credit.setName("授信部");
		credit.setOrder(2);
		credit.setStatus(0);
		credit.setUpdateDate(new Date());
		credit.setUpdateUser("admin");
		List<Department> childsL2 = new ArrayList<>();
		childsL2.add(credit);
		Department manager = new Department();
		manager.setCreatDate(new Date());
		manager.setCreateUser("admin");
		manager.setName("管理中心");
		manager.setOrder(3);
		manager.setStatus(0);
		manager.setUpdateDate(new Date());
		manager.setUpdateUser("admin");
		List<Department> childsL3 = new ArrayList<>();
		childsL3.add(manager);
		credit.setChild(childsL3);
		deaprtMent.setChild(childsL2);
		departmentSevice.saveOrUpdate(deaprtMent);
	}
}
