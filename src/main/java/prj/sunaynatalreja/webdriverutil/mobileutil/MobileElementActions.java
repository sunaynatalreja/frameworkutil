/**
 * 
 */
package prj.sunaynatalreja.webdriverutil.mobileutil;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Sequence;

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
	
private static MobileElementActions mobileElementActions;
private MobileElementActions()
{}
	
	public static MobileElementActions getInstance()
    {
        if (mobileElementActions == null)
        	mobileElementActions = new MobileElementActions();
  
        return mobileElementActions;
    }	
	
	public  void longPressMobileElement(WebDriver driver,WebElement element,String elementDescription) throws Exception
	{
		try {
			if (!waitForElement(driver, element))  
				throw new Exception(elementDescription + " not found in page!!");
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence longPress = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                            element.getLocation().getX(), element.getLocation().getY()))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(2)))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			((org.openqa.selenium.interactions.Interactive) driver).perform(Collections.singletonList(longPress));
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
	public void mobileTap(WebDriver driver, WebElement element, String elementDescription) throws Exception {
        try {
            if (!waitForElement(driver, element))
                throw new Exception(elementDescription + " not found in page!!");

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                            element.getLocation().getX(), element.getLocation().getY()))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(100)))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            ((org.openqa.selenium.interactions.Interactive) driver).perform(Collections.singletonList(tap));

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
	public void mobileSlider(WebDriver driver, WebElement source, WebElement dest, String elementDescription) throws Exception {
        try {
            if (!waitForElement(driver, source))
                throw new Exception(elementDescription + " not found in page!!");

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                            source.getLocation().getX(), source.getLocation().getY()))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(500)))
                    .addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(),
                            dest.getLocation().getX(), dest.getLocation().getY()))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            ((org.openqa.selenium.interactions.Interactive) driver).perform(Collections.singletonList(swipe));

        } catch (NoSuchElementException e) {
            throw new Exception(elementDescription + " not found in page!!");
        }
    }
	
	/**
	 * @param driver
	 * @param element
	 * @return
	 */
	public boolean waitForElement(WebDriver driver, WebElement element) {
        boolean isVisible = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        if (visibleElement.isDisplayed() && visibleElement.isEnabled()) {
            isVisible = true;
        }
        return isVisible;
    }
}
