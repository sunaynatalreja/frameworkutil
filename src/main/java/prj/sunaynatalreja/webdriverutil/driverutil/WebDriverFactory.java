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

import com.aventstack.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import prj.sunaynatalreja.extentreportutil.ExtentReportUtil;

/**
 * @author Sunayna Talreja
 */
public class WebDriverFactory {



	WebDriver driver=null;
	DesiredCapabilities capabilities ;
	private WebDriverFactory webDriverFactory;

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
	public synchronized WebDriver getDriver(String browser,String hubUrl, String device, String appPath) throws MalformedURLException 
	{

		setCapabilities(browser,device,appPath);
		driver=new RemoteWebDriver(new URL(hubUrl),capabilities);
		driver.manage().window().maximize();
		return driver;
	}

	private void setCapabilities(String browser,String device, String appPath) throws MalformedURLException
	{
		switch(browser) {
		case "chrome":
			capabilities=DesiredCapabilities.chrome();
			break;
		case "firefox":
			capabilities=DesiredCapabilities.firefox();
			break;
		case "internetexplorer":
			capabilities=DesiredCapabilities.internetExplorer();
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			break;
		case "android":
			capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
			capabilities.setCapability(MobileCapabilityType.APP, appPath);
			capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			capabilities.setCapability("autoDismissAlerts", true);
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("fullReset", true);
			break;
		case "edge":
			capabilities=DesiredCapabilities.edge();
			break;			
		}


	}

}
