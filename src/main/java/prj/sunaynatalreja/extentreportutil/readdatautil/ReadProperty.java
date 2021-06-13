/**
 * 
 */
package prj.sunaynatalreja.extentreportutil.readdatautil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sunayna Talreja
*/
public class ReadProperty {
	
static Properties prop=new Properties();
	
/*
 * Reads property from config.properties file
 * 
 */
	public static String getProperty(String key,String filename) throws IOException
	{
		
		InputStream fis=ReadProperty.class.getClassLoader().getResourceAsStream(filename);
		prop.load(fis);
		return prop.getProperty(key);
	}

}
