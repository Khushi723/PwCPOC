package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import base.BaseClass;

/**
 * Provides methods that can be applied to WebElements.
 * @author khushdeep.gupta
 */

public class WebElementExtensions extends BaseClass
{
/**
 * Makes use of the JavaScriptExecutor to scroll up/down to a particular element on the web page to view.
 * @param element
 */
	public static void scrollToElement(WebElement element)
    {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
	
	public static void clickElement(WebElement element)
    {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element); 
    }	
}

