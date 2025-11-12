/**
 * 
 */
package prj.sunaynatalreja.webdriverutil.browserutil;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sunayna Talreja
 */
public class BrowserElementActions {

	private static BrowserElementActions browserElementActions;

	private BrowserElementActions()
	{}

	public static BrowserElementActions getInstance()
	{
		if (browserElementActions == null)
			browserElementActions = new BrowserElementActions();

		return browserElementActions;
	}	



	/**
	 * @param driver
	 * @param element
	 * @return
	 */
	public  boolean waitForElement(WebDriver driver, WebElement element)
	{
		boolean statusOfElementToBeReturned=false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));
		if (waitElement.isDisplayed() && waitElement.isEnabled()) {
			statusOfElementToBeReturned = true;

		}
		return statusOfElementToBeReturned;
	}

	/**
	 * @param driver
	 * @param element
	 * @param elementDescription
	 * @throws Exception
	 */
	public  void clickOnElement(WebDriver driver,WebElement element,String elementDescription) throws Exception
	{
		try {
			if (!waitForElement(driver, element))  
				throw new Exception(elementDescription + " not found in page!!");

			element.click();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}

	/**
	 * @param driver
	 * @param element
	 * @param txtToSend
	 * @param elementDescription
	 * @throws Exception
	 */
	public  void typeOnElement(WebDriver driver,WebElement element,String txtToSend, String elementDescription) throws Exception
	{
		try {
			if (!waitForElement(driver, element))  
				throw new Exception(elementDescription + " not found in page!!");
			element.clear();
			element.sendKeys(txtToSend);
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}


	/**
	 * @param driver
	 */
	public  void waitForPageLoad(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState"
						).equals("complete");}});

	}


	/**
	 * @param element
	 * @param driver
	 * @param description
	 * @throws Exception
	 */
	public void mouseHoverAction(WebElement element, WebDriver driver, String description) throws Exception {
		Actions act=new Actions(driver);
		try {
			if (!waitForElement(driver, element))  
				throw new Exception(description + " not found in page!!");
			act.moveToElement(element);
			act.perform();
		} catch (NoSuchElementException e) {
			throw new Exception(description + " not found in page!!");
		}

	}

}
