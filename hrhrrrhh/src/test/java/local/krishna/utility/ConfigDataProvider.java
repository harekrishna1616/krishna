package local.krishna.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider() {
	File file=new File("./Config/Config.properties");
	
	try {
		FileInputStream fis=new FileInputStream(file);
		pro=new Properties();
		pro.load(fis);
	} catch (Exception e) {
		System.out.println("Unable to read Properties file");
	}
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getURL() {
		return pro.getProperty("SIT_URL");
	}

}
