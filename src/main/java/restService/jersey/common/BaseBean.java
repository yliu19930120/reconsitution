package restService.jersey.common;

import java.util.Date;

public class BaseBean {
	
	public final static Integer NOT_USE =0;
	public final static Integer IN_USE = 1;

	private String id;
	private Integer status;
	private Date creatDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	public Integer getStatus() {
		return status;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
