package restService.jersey.common;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import restService.jersey.util.MongoUtil;

public abstract class BaseDao<T> {

	public abstract String getDbName() ;
	
	public abstract String getCollectionName() ;
	
	public abstract Bson getUniqueIndex(T java);
		
	public abstract Logger getLogger();
	
	public MongoCollection<Document> getCollection() {
		MongoCollection<Document> collection = MongoUtil.getCollection(getDbName(), getCollectionName());
		return collection;
	}
	public void saveOrUpdate(T java){
		@SuppressWarnings("unchecked")
		T result = selectByUnique(java,(Class<T>)java.getClass());
		if(result==null){
			getCollection().insertOne(MongoUtil.adaptToDocuemnt(java));
		}else{
			getCollection().replaceOne(getUniqueIndex(java), MongoUtil.adaptToDocuemnt(java));
		}
	}
	
	public void saveMany(List<T> list){
		List<Document> documents = new ArrayList<>();
		list.forEach(t-> documents.add(MongoUtil.adaptToDocuemnt(t)));
		getCollection().insertMany(documents);
	}
	
	public void deleteByUnique(T java){
		getCollection().deleteOne(getUniqueIndex(java));
	}
	
	public T selectByUnique(T java,final Class<T> clazz){
          
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
		getCollection().find(filter).sort(sort).forEach(block);
		return list;
	}
	
	public List<T> select(T filter,final Class<T> clazz){

		return select(MongoUtil.adaptToDocuemnt(filter),clazz);
	}
	
	public List<T> select(T filter,Bson sort,final Class<T> clazz){

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
		getCollection().find(filter).sort(sort).forEach(block);
		return list;
	}
	
	public T selectOne(Bson filter,final Class<T> clazz){
		return MongoUtil.adaptToJava(getCollection().find(filter).first(), clazz);
	}
	
	public T selectOne(T filter,final Class<T> clazz){
		return selectOne(MongoUtil.adaptToDocuemnt(filter),clazz);
	}
	
	public T selectOne(T filter,Bson sort,final Class<T> clazz){
		return selectOne(MongoUtil.adaptToDocuemnt(filter),clazz);
	}
}
