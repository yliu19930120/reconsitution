package restService.jersey.jsonAdapter;

import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

public class LongDefaultNullAdapter implements JsonDeserializer<Long> {
	private static Logger log = LoggerFactory.getLogger(DoubleDefault0Adapter.class);
	
	@Override
	public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			if (json.getAsString().equals("") || json.getAsString().equals("null")) {// 定义为long类型,如果后台返回""或者null,则返回0
				return null;
			}
		} catch (Exception ignore) {
			log.info("转换成Long出错, json={}", json.toString());
		}
		try {
			return json.getAsLong();
		} catch (NumberFormatException e) {
			throw new JsonSyntaxException(e);
		}
	}

}
