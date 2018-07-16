package restService.jersey.common;


import java.util.List;
import org.bson.conversions.Bson;

public interface BaseService<T> {

    public void saveOrUpdate(T java);
    
    public void saveMany(List<T> list);
    
	public void deleteByUnique(T java);
	
	public T selectByUnique(T java);
		
	public List<T> select(T filter,Bson sort);
	
	public List<T> select(T filter);
    
    public List<T> select(Bson filter,Bson sort,final Class<T> clazz);
	
	public List<T> select(Bson filter,final Class<T> clazz);
			
	public T selectOne(T filter);
    
    public T selectOne(Bson filter,final Class<T> clazz);

    public void update(T java);
    
}
