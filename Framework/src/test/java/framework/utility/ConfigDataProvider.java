package framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider()
	{
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("unable to load Config File >>"+ e.getMessage());
		}
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	public String getQaURL()
	{
		return pro.getProperty("qaUrl");
	}
	public String getConfigData(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
}
