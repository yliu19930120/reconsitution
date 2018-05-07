package restService.jersey.bean;

import java.util.List;

import restService.jersey.common.BaseBean;

public class Menu extends BaseBean{

	private String id;
	private String name;
	private String url;
	private List<Menu> child;
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public List<Menu> getChild() {
		return child;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setChild(List<Menu> child) {
		this.child = child;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
