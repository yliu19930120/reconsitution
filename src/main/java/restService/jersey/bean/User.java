package restService.jersey.bean;



import restService.jersey.common.BaseBean;

public class User extends BaseBean{

	private String account;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String rootNode;
	
	public String getRootNode() {
		return rootNode;
	}
	public void setRootNode(String rootNode) {
		this.rootNode = rootNode;
	}
	public String getAccount() {
		return account;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
