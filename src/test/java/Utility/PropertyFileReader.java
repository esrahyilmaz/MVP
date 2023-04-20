package Utility;

import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileReader {
	static Properties property = new Properties();
	public static final String filePath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
	public static String getProperty(String key) throws IOException 
	 {
	 	
	 	try {
	 		property.load(new FileInputStream(filePath));
	 	} catch (IOException e) {
	 		System.out.println("Unable to load Data");
	 	}
	 	return property.getProperty(key);
	 }
	
	public static String setProperty(String key,String value) throws IOException 
	 {
		try {
		PropertiesConfiguration config = new PropertiesConfiguration(filePath);
		config.setProperty(key, value);
		config.save();
 	 		
	 	} catch (Exception e) {
	 		System.out.println("Unable to load Data");
	 	}
	 	return property.getProperty(key);
	 }
	
}
