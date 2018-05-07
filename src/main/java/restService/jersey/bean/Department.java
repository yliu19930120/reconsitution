package restService.jersey.bean;

import java.util.List;

import restService.jersey.common.BaseBean;

public class Department extends BaseBean{

	private String id;
	private String name;
	private List<String> roleIds;
	private List<Department> child;
	public String getName() {
		return name;
	}
	public List<Department> getChild() {
		return child;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setChild(List<Department> child) {
		this.child = child;
	}
	public List<String> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
