package restService.jersey.bean;

import java.util.List;

import restService.jersey.common.BaseBean;

public class Role extends BaseBean{

	private String id;
	private String name;
	private String code;
	private List<Long> menuIds;
	private List<String> userIds;
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public List<Long> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
