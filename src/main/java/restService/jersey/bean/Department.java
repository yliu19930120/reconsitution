package restService.jersey.bean;

import java.util.List;

public class Department {

	private Long id;
	private String name;
	private Integer order;
	private List<Role> roles;
	private List<Department> child;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getOrder() {
		return order;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public List<Department> getChild() {
		return child;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setChild(List<Department> child) {
		this.child = child;
	}
	
}
