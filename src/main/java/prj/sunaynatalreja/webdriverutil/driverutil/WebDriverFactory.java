/**
 * 
 */
package prj.sunaynatalreja.webdriverutil.driverutil;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * @author Sunayna Talreja
 */
public class WebDriverFactory {



	WebDriver driver=null;
	DesiredCapabilities capabilities ;

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
	@SuppressWarnings("deprecation")
	public synchronized WebDriver getDriver(String browser, String hubUrl, String device, String appPath) throws MalformedURLException {

        if (browser.equalsIgnoreCase("android")) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(device)
                    .setPlatformName("Android")
                    .setApp(appPath)
                    .setAutoGrantPermissions(true)
                    .setFullReset(true)
                    .setNewCommandTimeout(Duration.ofSeconds(120));
            
            driver = new AndroidDriver(new URL(hubUrl), options);
        } 
        else if (browser.equalsIgnoreCase("chrome")) {
            driver = new RemoteWebDriver(new URL(hubUrl), new ChromeOptions());
            driver.manage().window().maximize();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(new URL(hubUrl), new FirefoxOptions());
            driver.manage().window().maximize();
        } 
        else if (browser.equalsIgnoreCase("internetexplorer")) {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions()
                    .ignoreZoomSettings()
                    .introduceFlakinessByIgnoringSecurityDomains();
            driver = new RemoteWebDriver(new URL(hubUrl), ieOptions);
            driver.manage().window().maximize();
        }

        return driver;
    }

}
