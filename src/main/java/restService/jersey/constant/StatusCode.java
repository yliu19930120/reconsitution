package restService.jersey.constant;

public enum StatusCode {

	SUCC(0,"请求成功"),
	FAILED(500,"请求失败"),
	NOT_LOGIN(401,"未登录");
	
	private StatusCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private Integer code;
	private String msg;
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
