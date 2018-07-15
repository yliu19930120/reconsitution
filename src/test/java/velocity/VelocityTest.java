package velocity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

public class VelocityTest {
	
	private final static String path = "E:/学习资料/资料/开源资料/rest/jersey/src/main/java/restService/jersey/";
	
	@Test
	public void build() {     
		generatorCode("User");
	}
	
	public static List<String> getTemplates(){
		List<String> templates = new ArrayList<String>();
		templates.add("template/ServiceImpl.java.vm");
		templates.add("template/Service.java.vm");
		templates.add("template/Dao.java.vm");
		return templates;
	}
	
	/**
	 * 生成代码
	 */
	public static void generatorCode(String beanName){
		//设置velocity资源加载器
		Properties prop = new Properties();  
		prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");  
		Velocity.init(prop);
        //获取模板列表
		List<String> templates = getTemplates();
		Map<String, Object> map = new HashMap<>();
		map.put("beanName", beanName);
		map.put("beanname", StringUtils.uncapitalize(beanName));
		VelocityContext context = new VelocityContext(map);
		for(String template : templates){
			//渲染模板
			StringWriter sw = new StringWriter();
			Template tpl = Velocity.getTemplate(template, "UTF-8");
			tpl.merge(context, sw);
			
			try {
				String fileName = getFileName(template,beanName,"jersey");
				System.out.println("保存到:"+fileName);
				//添加到zip
				FileOutputStream out = new FileOutputStream(new File(fileName));
				
				IOUtils.write(sw.toString(), out, "UTF-8");
				IOUtils.closeQuietly(sw);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 获取文件名
	 */
	public static String getFileName(String template, String beanName, String packageName){
	
		if(template.contains("ServiceImpl.java.vm")){
			return path + "service" + File.separator + beanName + "ServiceImpl.java";
		}
		if(template.contains("Service.java.vm")){
			return path + "service" + File.separator + beanName + "Service.java";
		}
		if(template.contains("Dao.java.vm")){
			return path + "dao" + File.separator + beanName + "Dao.java";
		}
		return null;
	}
}
