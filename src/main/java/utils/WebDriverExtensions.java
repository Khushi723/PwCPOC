package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseClass;

/** Contains the Explicit wait methods to be applied to WebDriver to wait under the specified conditions.
 * @author khushdeep.gupta
 */

public class WebDriverExtensions extends BaseClass
{
/**
 * Makes WebDriver explicitly wait for the specified time until a particular webElement is visible on the webpage
 * @param locator
 * @return element
 */
	public static WebElement ElementIsVisible(By locator, Duration timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
	
/**
 * Makes WebDriver explicitly wait for the specified time until a particular webElement is in a clickable position
 * @param element
 * @param timeOutInSec
 * @return elemnt
 */
	public static WebElement ElementToBeClickable(WebElement element, Duration timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        WebElement elemnt = wait.until(ExpectedConditions.elementToBeClickable(element));
        return elemnt;
    }
	
/**
 * Makes WebDriver wait until a particular webElement such as Loader gets invisible and WebPage gets fully loaded.
 * @param locator
 * @param timeOutInSec
 * @return element
 */
	public static Boolean WaitForPageLoad(By locator, Duration timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        return element;
    }
	
/**
 * Makes WebDriver wait until an iFrame is available to be switched to it.
 * @param locator
 * @param timeOutInSec
 * @return drivr
 */
	public static WebDriver FrameToBeAvailableToSwitch(By locator, Duration timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        WebDriver drivr = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        return drivr;
    }
	
/**
* Method to return the page title.
* @return String
*/
	public static String getPageTitle()
	{
		return driver.getTitle();
	}
}
