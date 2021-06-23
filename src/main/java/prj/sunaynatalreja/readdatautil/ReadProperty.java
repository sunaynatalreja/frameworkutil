/**
 * 
 */
package prj.sunaynatalreja.readdatautil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;

import prj.sunaynatalreja.webdriverutil.browserutil.BrowserElementActions;

/**
 * @author Sunayna Talreja
*/
public class ReadProperty {
	
private static ReadProperty readProperty = null;
private static Properties prop;

private ReadProperty()
{
	prop =new Properties();
}

public static ReadProperty getInstance()
{
    if (readProperty == null)
    	readProperty = new ReadProperty();

    return readProperty;
}
/**
 * Reads property from config.properties file
 * 
 */
	public String getProperty(String key,String filename) throws IOException
	{
		InputStream fis=ReadProperty.class.getClassLoader().getResourceAsStream(filename);
		prop.load(fis);
		String propertyValue=prop.getProperty(key);
		fis.close();
		return propertyValue;
	}

}
