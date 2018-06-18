package restService.jersey.common;

import com.mongodb.util.JSON;

import restService.jersey.constant.StatusCode;

public class BaseAction {


	public String succ(){
		return JSON.serialize(StatusCode.SUCC);
	}
}
