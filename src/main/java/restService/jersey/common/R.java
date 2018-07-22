package restService.jersey.common;

import java.util.HashMap;
import java.util.Map;

import restService.jersey.constant.StatusCode;
import restService.jersey.util.JsonUtil;

public class R extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 874840944543547684L;

	public R() {
		put("code", 0);
		
	}
	
	public static R error() {
		return error(StatusCode.FAILED.getCode(), StatusCode.FAILED.getMsg());
	}
	public static R noLogin() {
		return error(StatusCode.NOT_LOGIN.getCode(), StatusCode.NOT_LOGIN.getMsg());
	}
	public static R error(String msg) {
		return error(StatusCode.FAILED.getCode(), msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	public String toJson(){
		return JsonUtil.toJson(this);
	}
}
