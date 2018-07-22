package restService.jersey.common;

import java.util.Date;
import java.util.List;

import org.bson.conversions.Bson;

public abstract class BaseServiceImpl<T extends BaseBean> implements BaseService<T>{

	public abstract BaseDao<T> getBaseDao();
	@Override
	public void saveOrUpdate(T java) {
		getBaseDao().saveOrUpdate(java);
	}

	@Override
	public void saveMany(List<T> list) {
		getBaseDao().saveMany(list);
	}

	@Override
	public void deleteByUnique(T java) {
		getBaseDao().deleteByUnique(java);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T selectByUnique(T java) {
		return getBaseDao().selectByUnique(java, (Class<T>)java.getClass());
	}

	@Override
	public List<T> select(T filter, Bson sort) {
		return getBaseDao().select(filter, sort, (Class<T>)filter.getClass());
	}

	@Override
	public List<T> select(T filter) {
		return getBaseDao().select(filter, (Class<T>)filter.getClass());
	}

	@Override
	public List<T> select(Bson filter, Bson sort,final Class<T> clazz) {
		return getBaseDao().select(filter, sort, clazz);
	}

	@Override
	public List<T> select(Bson filter,final Class<T> clazz) {
		return getBaseDao().select(filter, clazz);
	}

	@Override
	public T selectOne(T filter) {
		return getBaseDao().selectOne(filter, (Class<T>)filter.getClass());
	}

	@Override
	public T selectOne(Bson filter,final Class<T> clazz) {
		return getBaseDao().selectOne(filter, clazz);
	}

	@Override
	public void update(T java) {
		java.setUpdateDate(new Date());
		getBaseDao().update(java);
	}

}
