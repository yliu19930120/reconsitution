package restService.jersey.dao;

import redis.clients.jedis.Jedis;
import restService.jersey.util.JsonUtil;
import restService.jersey.util.RedisUtil;

/**
 * redis增删改查
 * @author liuyo
 *
 */
public class RedisDao {
	
	private final static RedisDao redisDao = new RedisDao();
	
	public static RedisDao getInstance(){
		return redisDao;
	}
	
	private RedisDao(){
		
	}
	public void set(String key,String value){
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key, value);
		jedis.close();
	}
	public String get(String key){
		Jedis jedis = RedisUtil.getJedis();
		String value = jedis.get(key);
		jedis.close();
		return value;
	}
	public<T> void set(String key,T t){
		String value = JsonUtil.toJson(t);
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key, value);
		jedis.close();
	}
	public<T> T get(String key,Class<T> clazz){
		Jedis jedis = RedisUtil.getJedis();
		String value = jedis.get(key);
		jedis.close();
		return JsonUtil.toJava(value, clazz);
	}
	public long getKeyNum(){
		Jedis jedis = RedisUtil.getJedis();
		long total = jedis.dbSize();
		jedis.close();
		return total;
	}
}
