package restService.jersey.auth;

import java.util.ArrayList;
import java.util.List;

public class AuthConstant {

	public final static List<String> NO_LOGIN_URLS  = new ArrayList<>();
	
	static {
		NO_LOGIN_URLS.add("user/.*");
		NO_LOGIN_URLS.add("file/.*");
	}
}
