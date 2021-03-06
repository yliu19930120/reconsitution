package restService.jersey.util;


import java.util.Map;
import org.bson.Document;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class JsonUtil {
	
	private final static String DEFAULT_DATE_FORMAT = "yyyyMMdd HH:mm:ss";
	static{
		JSON.DEFFAULT_DATE_FORMAT = DEFAULT_DATE_FORMAT;
	}
	
	/**
	 * 转JSON
	 * @param obj
	 * @return
	 */
	 public static String toJson(Object obj){
		 return JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat);
	 };
	 /**
	  * 转实体
	  * @param json
	  * @param clazz
	  * @return
	  */
	 public static <T> T toJava(String json,Class<T> clazz){
		 return JSON.parseObject(json, clazz);
	 }
	 
	 public static Document strToDoc(String json){
		 return new Document((Map)JSON.parse(json));
	 }
}
