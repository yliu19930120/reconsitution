package restService.jersey.service;

import java.util.List;

import org.bson.conversions.Bson;

import restService.jersey.bean.Role;
import restService.jersey.dao.RoleDao;

public class RoleServiceImpl implements RoleService{
	
	private final static RoleServiceImpl roleService = new RoleServiceImpl();
	
	RoleDao roleDao = RoleDao.getInstance();
	
	public static RoleServiceImpl getInstence(){
		return roleService;
	}

	private RoleServiceImpl(){
		
	}
	
	@Override
	public void saveOrUpdate(Role java) {
		roleDao.saveOrUpdate(java);
		
	}

	@Override
	public void deleteByUnique(Role java) {
		roleDao.deleteByUnique(java);
	}

	@Override
	public Role selectByUnique(Role java) {

		return roleDao.selectByUnique(java, Role.class);
	}

	@Override
	public List<Role> select(Role filter, Bson sort) {

		return roleDao.select(filter, Role.class);
	}

	@Override
	public List<Role> select(Role filter) {
		return roleDao.select(filter,  Role.class);
	}

	@Override
	public List<Role> select(Bson filter, Bson sort) {
		return roleDao.select(filter,sort, Role.class);
	}

	@Override
	public List<Role> select(Bson filter) {
		return roleDao.select(filter, Role.class);
	}

	@Override
	public Role selectOne(Role filter) {
		return roleDao.selectOne(filter,  Role.class);
	}

	@Override
	public Role selectOne(Bson filter) {
		return roleDao.selectOne(filter, Role.class);
	}

	@Override
	public void saveMany(List<Role> list) {
		roleDao.saveMany(list);
	}

}
