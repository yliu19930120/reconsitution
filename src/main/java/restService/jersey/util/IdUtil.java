package restService.jersey.util;

import java.util.UUID;

public class IdUtil {
	public static String getId() {
		return getId( "" );
	}
	
	public static String getId( String prefix ) {
		UUID uuid=UUID.randomUUID();
		return prefix+uuid.toString();
	}

	public static String tokenId() {
		return getId( "tk-" );
	}
	
}

