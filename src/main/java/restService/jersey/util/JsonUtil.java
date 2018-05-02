package restService.jersey.util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import restService.jersey.jsonAdapter.DoubleDefault0Adapter;
import restService.jersey.jsonAdapter.DoubleDefaultNullAdapter;
import restService.jersey.jsonAdapter.IntegerDefault0Adapter;
import restService.jersey.jsonAdapter.IntegerDefaultNullAdapter;
import restService.jersey.jsonAdapter.LongDefault0Adapter;
import restService.jersey.jsonAdapter.LongDefaultNullAdapter;

/**
 * @author 刘永华 JSON转换包
 */
public class JsonUtil {
	public static final String DATE_FORMAT = "yyyyMMdd HH:mm:ss";

	private static Gson genericGson;
	private static Gson wechatGson;

	static {
		genericGson = getGsonBuilder().setDateFormat(DATE_FORMAT).create();
		wechatGson = getGsonBuilder().setDateFormat(DATE_FORMAT)
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
	}

	/**
	 * 向web接口输出转换json。web接口注意2点：
	 * 
	 * 1. 注解为<code>DbOnly</code>的字段不输出到web，如用户的password字段； 2.
	 * 日期以格式"yyyyMMdd-HH:mm:ss"输出
	 * 
	 * @return
	 */
	public static Gson getGson() {
		return genericGson;
	}

	public static Gson getGsonWithDateFormat(String pattern) {
		return getGsonBuilder().setDateFormat(pattern).create();
	}

	protected static GsonBuilder getGsonBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Integer.class, new IntegerDefaultNullAdapter())
				.registerTypeAdapter(int.class, new IntegerDefault0Adapter())
				.registerTypeAdapter(Long.class, new LongDefaultNullAdapter())
				.registerTypeAdapter(long.class, new LongDefault0Adapter())
				.registerTypeAdapter(Double.class, new DoubleDefaultNullAdapter())
				.registerTypeAdapter(double.class, new DoubleDefault0Adapter());
		// .registerTypeAdapter(Date.class, new DateDefaultAdapter());

		gsonBuilder.setPrettyPrinting();
		return gsonBuilder;
	}

	public static Gson getWechatGson() {
		return wechatGson;
	}

	public static <T> T adapt(String json, Class<T> clazz) {
		if (json == null) {
			return null;
		}

		Gson gson = getGson();

		return gson.fromJson(json, clazz);
	}

	public static <T> List<T> adapt(String json) {
		if (json == null) {
			return null;
		}

		Gson gson = getGson();
		Type type = new TypeToken<List<T>>() {
		}.getType();

		return gson.fromJson(json, type);
	}
}
