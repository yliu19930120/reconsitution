package restService.jersey.common;

import java.util.Date;

import com.mongodb.ReflectionDBObject;

public class BaseBean{
	
	private Integer status;
	private Date creatDate;
	private String createUser;
	private Date updateDate;
	private Integer order;
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	
}
