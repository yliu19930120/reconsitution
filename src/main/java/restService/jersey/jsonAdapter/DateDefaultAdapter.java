package restService.jersey.jsonAdapter;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import restService.jersey.util.JsonUtil;


public class DateDefaultAdapter implements JsonDeserializer<Date> {
	private static Logger log = LoggerFactory.getLogger(DoubleDefault0Adapter.class);
	
	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			String str = json.getAsString();
			if (str.equals("") || str.equals("null")) {// 定义为long类型,如果后台返回""或者null,则返回0
				return null;
			}
			SimpleDateFormat format = new SimpleDateFormat(JsonUtil.DATE_FORMAT);
			return format.parse(str);
		} catch (Exception ignore) {
			log.info("转换成Long出错, json={}", json.toString());
		}
		return null;
	}

}
