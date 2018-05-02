package restService.jersey.bean;


import java.util.List;

public class User extends CommonBean{

	private Long id;
	private String account;
	private String name;
	private String password;
	private String email;
	private Long phone;

	private List<Role> roles;
	public Long getId() {
		return id;
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
	public Long getPhone() {
		return phone;
	}

	public void setId(Long id) {
		this.id = id;
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
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	
}
