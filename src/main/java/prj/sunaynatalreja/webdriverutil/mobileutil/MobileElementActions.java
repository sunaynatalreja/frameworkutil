/**
 * 
 */
package prj.sunaynatalreja.webdriverutil.mobileutil;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

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
	public static void longPressMobileElement(WebDriver driver,WebElement element,String elementDescription) throws Exception
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
	public static void mobileTap(WebDriver driver,WebElement element,String elementDescription) throws Exception
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
	public static void mobileSlider(WebDriver driver,WebElement orignalElement,WebElement destElement, String elementDescription) throws Exception
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
	public static boolean waitForElement(WebDriver driver, WebElement element)
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
