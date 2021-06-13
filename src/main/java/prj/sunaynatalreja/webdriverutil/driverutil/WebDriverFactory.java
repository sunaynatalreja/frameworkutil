/**
 * 
 */
package prj.sunaynatalreja.webdriverutil.driverutil;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Sunayna Talreja
 */
public class WebDriverFactory {

	static WebDriver driver=null;
	static DesiredCapabilities capabilities ;

	/**
	 * @author Sunayna Talreja
	 * This method is used to initialize the driver with required parameters
	 * @param browser provide browser name chrome/firefox/internetexplorer/edge/android
	 * @param hubUrl provide selenium grid hub url
	 * @param device name of device (to be provided in case of mobile, provide "" in other case)
	 * @param appPath provide path of apk (to be provided in case of mobile, provide "" in other case)
	 * @return WebDriver instance of the browser provided
	 * @throws MalformedURLException
	 */
	public static synchronized WebDriver get(String browser,String hubUrl, String device, String appPath) throws MalformedURLException 
	{
	


		if ("chrome".equalsIgnoreCase(browser)) {
			capabilities=DesiredCapabilities.chrome();
			driver=new RemoteWebDriver(new URL(hubUrl),capabilities);
			driver.manage().window().maximize();


		}
		else if ("firefox".equalsIgnoreCase(browser))
		{
			capabilities=DesiredCapabilities.firefox();
			driver=new RemoteWebDriver(new URL(hubUrl),capabilities);
			driver.manage().window().maximize();
		}
		else if ("internetexplorer".equalsIgnoreCase(browser))
		{
			capabilities=DesiredCapabilities.internetExplorer();
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

			driver=new RemoteWebDriver(new URL(hubUrl),capabilities);
			driver.manage().window().maximize();
		}
		else if ("android".equalsIgnoreCase(browser))
		{
			capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
			capabilities.setCapability(MobileCapabilityType.APP, appPath);
			capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			capabilities.setCapability("autoDismissAlerts", true);
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("fullReset", true);
			driver=new AndroidDriver(new URL(hubUrl),capabilities);
			//driver.switchTo().alert().accept();
		}
		else if ("edge".equalsIgnoreCase(browser))
		{
			capabilities=DesiredCapabilities.edge();
			driver=new RemoteWebDriver(new URL(hubUrl),capabilities);
			driver.manage().window().maximize();
		}
		return driver;
	}

}
