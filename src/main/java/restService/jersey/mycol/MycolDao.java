package restService.jersey.mycol;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import restService.jersey.util.MongoUtil;

public class MycolDao {
	
	private static MongoCollection<Document> collection;
	
	public static MongoCollection getCollection(){
		collection = MongoUtil.getCollection("credit", "mycol");
		return collection;
	}
	
	public List queryList() {
		final List<Document> list = new ArrayList<>();
		Block block = new Block<Document>() {
			@Override
			public void apply(Document arg0) {
				// TODO Auto-generated method stub
				list.add(arg0);
			}
		};
		collection.find().forEach(block);
		return list;
	}
   
}
