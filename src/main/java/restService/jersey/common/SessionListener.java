package restService.jersey.common;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import restService.jersey.util.JsonUtil;
/**
 * session属性监听器
 * @author liuyo
 *
 */
public class SessionListener implements HttpSessionAttributeListener{
	
	private  static final Logger log = LoggerFactory.getLogger(SessionListener.class);
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		log.info("session增加属性{}:{}",event.getName(),JsonUtil.toJson(event.getValue()));
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		log.info("session移除属性{}:{}",event.getName(),JsonUtil.toJson(event.getValue()));
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		log.info("session替换属性{}:{}",event.getName(),JsonUtil.toJson(event.getValue()));
	}

}
