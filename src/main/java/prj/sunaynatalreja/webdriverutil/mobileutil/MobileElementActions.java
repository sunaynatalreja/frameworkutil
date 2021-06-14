/**
 * 
 */
package prj.sunaynatalreja.webdriverutil.mobileutil;

import static  io.appium.java_client.touch.LongPressOptions.*;
import static  io.appium.java_client.touch.TapOptions.*;
import static  io.appium.java_client.touch.offset.ElementOption.*;
import prj.sunaynatalreja.webdriverutil.browserutil.BrowserElementActions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

/**
 * @author Sunayna Talreja
 */
public class MobileElementActions {
	
	/**
	 * @param driver
	 * @param element
	 * @param elementDescription
	 * @throws Exception
	 */
	
static MobileElementActions mobileElementActions;
	
	
	public static MobileElementActions getInstance()
    {
        if (mobileElementActions == null)
        	mobileElementActions = new MobileElementActions();
  
        return mobileElementActions;
    }	
	
	public  void longPressMobileElement(WebDriver driver,WebElement element,String elementDescription) throws Exception
	{
		TouchAction touch=new TouchAction((MobileDriver) driver);
		try {
			if (!waitForElement(driver, element))  
				throw new Exception(elementDescription + " not found in page!!");
			touch.longPress(longPressOptions().withElement(element(element))).perform();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}
	
	/**
	 * @param driver
	 * @param element
	 * @param elementDescription
	 * @throws Exception
	 */
	public  void mobileTap(WebDriver driver,WebElement element,String elementDescription) throws Exception
	{
		TouchAction touch=new TouchAction((MobileDriver) driver);
		try {
			if (!waitForElement(driver, element))  
				throw new Exception(elementDescription + " not found in page!!");
			touch.tap(tapOptions().withElement(element(element))).perform();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}
	
	/**
	 * @param driver
	 * @param orignalElement
	 * @param destElement
	 * @param elementDescription
	 * @throws Exception
	 */
	public  void mobileSlider(WebDriver driver,WebElement orignalElement,WebElement destElement, String elementDescription) throws Exception
	{
		TouchAction touch=new TouchAction((MobileDriver) driver);
		try {
			if (!waitForElement(driver, orignalElement))  
				throw new Exception(elementDescription + " not found in page!!");
			touch.longPress(longPressOptions().withElement(element(orignalElement)).withDuration(Duration.ofSeconds(2))).moveTo(element(destElement)).release().perform();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}
	
	/**
	 * @param driver
	 * @param element
	 * @return
	 */
	public  boolean waitForElement(WebDriver driver, WebElement element)
	{
		boolean statusOfElementToBeReturned=false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));
		if (waitElement.isDisplayed() && waitElement.isEnabled()) {
			statusOfElementToBeReturned = true;

		}
		return statusOfElementToBeReturned;
	}
	
	

	
	
	

}
