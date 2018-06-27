package restService.jersey.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import restService.jersey.util.IdUtil;
import restService.jersey.util.MongoUtil;

public abstract class BaseDao<T extends BaseBean> {

	public abstract String getDbName() ;
	
	public abstract String getCollectionName() ;
	
	public abstract Bson getUniqueIndex(T java);
		
	public abstract Logger getLogger();
	
	private void defaultBean(T java){
		java.setCreatDate(new Date());
		java.setUpdateDate(new Date());
		if(java.getId()==null)java.setId(IdUtil.getId());
		java.setStatus(BaseBean.IN_USE);
	}
	public MongoCollection<Document> getCollection() {
		MongoCollection<Document> collection = MongoUtil.getCollection(getDbName(), getCollectionName());
		return collection;
	}
	public void saveOrUpdate(T java){
		defaultBean(java);
		@SuppressWarnings("unchecked")
		T result = selectByUnique(java,(Class<T>)java.getClass());
		Document doc = null;
		if(result==null){
			doc = MongoUtil.adaptToDocuemnt(java);
			getLogger().info("向表:{}写入 {}",getCollectionName(),doc);
			getCollection().insertOne(doc);
		}else{
			doc = MongoUtil.adaptToDocuemnt(java);
			getLogger().info("向表:{}更新 {}",getCollectionName(),doc);
			getCollection().replaceOne(getUniqueIndex(java), doc);
		}
	}
	
	public void save(T java){
		defaultBean(java);
		Document doc = MongoUtil.adaptToDocuemnt(java);
		getLogger().info("向表:{}写入 {}",getCollectionName(),doc);
		getCollection().insertOne(doc);
	}
	public void saveMany(List<T> list){
		List<Document> documents = new ArrayList<>();
		getLogger().info("向表:{}批量写入",getCollectionName());
		list.forEach(t-> documents.add(MongoUtil.adaptToDocuemnt(t)));
		getCollection().insertMany(documents);
	}
	
	public void deleteByUnique(T java){
		getLogger().info("从表:{}同过主键删除记录",getCollectionName());
		getCollection().deleteOne(getUniqueIndex(java));
	}
	
	public T selectByUnique(T java,final Class<T> clazz){
        Document doc = getCollection().find(getUniqueIndex(java)).first();
        getLogger().info("从表:{}查询结果",getCollectionName());
        if(doc==null)
        	return null;
        else 
		    return MongoUtil.adaptToJava(getCollection().find(getUniqueIndex(java)).first(), clazz);
	}
		
	
	public List<T> select(Bson filter,final Class<T> clazz){
		final List<T> list = new ArrayList<>();
		Block<Document> block= new Block<Document>() {

			@Override
			public void apply(Document t) {
				list.add(MongoUtil.adaptToJava(t, clazz));
			}
		};
		getLogger().info("从表:{}查询结果,查询条件:{}",getCollectionName(),filter);
		getCollection().find(filter).forEach(block);
		return list;
	}
	
	public List<T> select(Bson filter,Bson sort,final Class<T> clazz){
		final List<T> list = new ArrayList<>();
		Block<Document> block= new Block<Document>() {

			@Override
			public void apply(Document t) {
				list.add(MongoUtil.adaptToJava(t, clazz));
			}
		};
		getLogger().info("从表:{}查询结果,查询条件{},排序条件{}",getCollectionName(),filter,sort);
		getCollection().find(filter).sort(sort).forEach(block);
		return list;
	}
	
	public List<T> select(T filter,final Class<T> clazz){
		getLogger().info("从表:{}查询结果",getCollectionName());
		return select(MongoUtil.adaptToDocuemnt(filter),clazz);
	}
	
	public List<T> select(T filter,Bson sort,final Class<T> clazz){
		getLogger().info("从表:{}查询结果,排序条件{}",getCollectionName(),sort);
		return select(MongoUtil.adaptToDocuemnt(filter),sort,clazz);
	}
	
	public List<Document> select(Bson filter){
		final List<Document> list = new ArrayList<>();
		Block<Document> block= new Block<Document>() {

			@Override
			public void apply(Document t) {
				list.add(t);
			}
		};
		getLogger().info("从表:{}查询结果,查询条件{}",getCollectionName(),filter);
		getCollection().find(filter).forEach(block);
		return list;
	}
	
	public List<Document> select(Bson filter,Bson sort){
		final List<Document> list = new ArrayList<>();
		Block<Document> block= new Block<Document>() {

			@Override
			public void apply(Document t) {
				list.add(t);
			}
		};
		getLogger().info("从表:{}查询结果,查询条件{},排序条件{}",getCollectionName(),filter,sort);
		getCollection().find(filter).sort(sort).forEach(block);
		return list;
	}
	
	public T selectOne(Bson filter,final Class<T> clazz){
		getLogger().info("从表:{}查询结果,查询条件{},排序条件{}",getCollectionName(),filter);
		return MongoUtil.adaptToJava(getCollection().find(filter).first(), clazz);
	}
	
	public T selectOne(T filter,final Class<T> clazz){
		getLogger().info("从表:{}查询结果",getCollectionName());
		return selectOne(MongoUtil.adaptToDocuemnt(filter),clazz);
	}
	
}
