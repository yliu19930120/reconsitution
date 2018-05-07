package restService.jersey.service;

import java.util.List;
import org.bson.conversions.Bson;
import restService.jersey.bean.Department;
import restService.jersey.dao.DepartmentDao;

public class DepartmentSeviceImpl implements DepartmentSevice{
	
	private static DepartmentSeviceImpl departmentSevice = new DepartmentSeviceImpl();
	
	public static DepartmentSeviceImpl getInstance(){
		return departmentSevice;
	}
	
	private DepartmentSeviceImpl(){
		
	}
	
	DepartmentDao departmentDao = DepartmentDao.getInstence();

	@Override
	public void saveOrUpdate(Department user) {
		departmentDao.saveOrUpdate(user);
	}

	@Override
	public void deleteByUnique(Department java) {
		departmentDao.deleteByUnique(java);
	}

	@Override
	public Department selectByUnique(Department java) {
		return departmentDao.selectByUnique(java, Department.class);
	}

	@Override
	public List<Department> select(Department filter, Bson sort) {
		return departmentDao.select(filter, Department.class);
	}

	@Override
	public List<Department> select(Department filter) {
		return departmentDao.select(filter, Department.class);
	}

	@Override
	public Department selectOne(Department filter) {
		return departmentDao.selectOne(filter, Department.class);
	}

	@Override
	public List<Department> select(Bson filter, Bson sort) {
		return departmentDao.select(filter, sort, Department.class);
	}

	@Override
	public List<Department> select(Bson filter) {
		return departmentDao.select(filter, Department.class);
	}

	@Override
	public Department selectOne(Bson filter) {
		return departmentDao.selectOne(filter, Department.class);
	}

	@Override
	public void saveMany(List<Department> list) {
		departmentDao.saveMany(list);
	}

}
