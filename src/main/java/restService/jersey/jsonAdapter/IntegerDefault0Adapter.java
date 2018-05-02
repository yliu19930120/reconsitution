package restService.jersey.jsonAdapter;

import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

public class IntegerDefault0Adapter implements JsonDeserializer<Integer> {
	private static Logger log = LoggerFactory.getLogger(IntegerDefault0Adapter.class);

	@Override
	public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			if (json.getAsString().equals("") || json.getAsString().equals("null")) {// 定义为int类型,如果后台返回""或者null,则返回0
				return 0;
			}
		} catch (Exception ignore) {
			log.info("转换成int出错, json={}", json.toString());
		}
		try {
			return json.getAsInt();
		} catch (NumberFormatException e) {
			throw new JsonSyntaxException(e);
		}
	}

}
