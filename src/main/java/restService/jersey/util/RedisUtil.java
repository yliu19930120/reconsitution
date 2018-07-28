package restService.jersey.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import restService.jersey.bean.RedisPoolStatus;

/**
 * redis连接池
 * 
 * @author liuyo
 *
 */
public class RedisUtil {

	private final static Logger log = LoggerFactory.getLogger(RedisUtil.class);

	private static JedisPool pool;

	private final static String redis_server = "127.0.0.1";

	static {
		initPool();
	}
	
	private static void initPool(){
		log.info("启动redis连接池");
		JedisPoolConfig config = new JedisPoolConfig();// Jedis池配置
		config.setMaxTotal(100);
		config.setMaxIdle(1000 * 60);// 对象最大空闲时间
		config.setMaxWaitMillis(1000 * 10);// 获取对象时最大等待时间
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, redis_server);
		log.info("redis连接池启动完毕:{}",JsonUtil.toJson(config));
	}

	public static Jedis getJedis() {

		Jedis jedis = null;
		try {
			jedis = pool.getResource();
		} catch (Exception e) {
			log.error("redis连接错误:{}", e);
		}
		return jedis;
	}

	public static void returnResource(Jedis jedis) {
		pool.returnResource(jedis);
	}
	public static void close(){
		pool.close();
	}
	
	public static RedisPoolStatus getStatus(){
		RedisPoolStatus status = new RedisPoolStatus();
		status.setActives(pool.getNumActive());
		status.setIdle(pool.getNumIdle());
		status.setWaiters(pool.getNumWaiters());
		log.info("redis状态:{}",JsonUtil.toJson(status));
		return status;
	}
}
