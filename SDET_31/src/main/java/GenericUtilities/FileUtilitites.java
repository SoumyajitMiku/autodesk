package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilitites {
	public String  getPropertyFiledata(String key) throws Throwable 
	{
	
		FileInputStream fis= new FileInputStream("./src\\main\\resources\\commonData\\credentials.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
}
