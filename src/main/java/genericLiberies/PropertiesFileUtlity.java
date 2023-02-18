package genericLiberies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This Class Contains all  reusable methods to perform operations on property file
 * @author KanyaKavi
 *
 */

public class PropertiesFileUtlity 
{
	private Properties property;
	/**
	 * this method is used to initialize property file
	 * @param filePath
	 */
	public void propertyFileInitilization(String filePath)
	{
		FileInputStream fis=null;
		try 
		{
			fis=new FileInputStream(filePath);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		    property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * This method returns the data from properties file based on the key passed
	 * @param key
	 * @return
	 */
	public String fetchProperties(String key)
	{
		return property.getProperty(key);
	}

}
