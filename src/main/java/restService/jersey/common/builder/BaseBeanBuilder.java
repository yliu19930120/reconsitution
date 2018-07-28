package restService.jersey.common.builder;

import java.util.Date;

import restService.jersey.common.BaseBean;
import restService.jersey.util.IdUtil;

/**
 * 默认bean建造者
 * @author liuyo
 *
 */
public abstract class BaseBeanBuilder<T extends BaseBean> {
	

	public abstract T buildDefaultBeab();
	
	public T getDefauleBean(){
		T t = buildDefaultBeab();
		t.setUpdateDate(new Date());
		t.setId(IdUtil.getId());
		return t;
	}
}
