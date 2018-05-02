package restService.jersey.jsonAdapter;

import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

public class DoubleDefault0Adapter implements JsonDeserializer<Double> {
	private static Logger log = LoggerFactory.getLogger(DoubleDefault0Adapter.class);

	@Override
	public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			if (json.getAsString().equals("") || json.getAsString().equals("null")) {// 定义为double类型,如果后台返回""或者null,则返回0.00
				return 0.00;
			}
		} catch (Exception ignore) {
			log.info("转换成double出错, json={}", json.toString());
		}
		try {
			return json.getAsDouble();
		} catch (NumberFormatException e) {
			throw new JsonSyntaxException(e);
		}
	}

}
