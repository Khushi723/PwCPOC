package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import base.BaseClass;

/** Class Sets the configuration of the different browsers.
 * @author khushdeep.gupta
 */
public class BrowserOptionsManager 
{
	
/** Method to set the parameters such as incognito mode, headless mode for Chrome Browser. 
 * Use WebDriver Manager to automatically update the Chromedriver to match with the Chrome Browser version. 
 * @param browserMode
 */
	public static void chromeOptions(String browserMode)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
        if (browserMode == "ChromeHeadless")
        {
            options.addArguments("headless");
            BaseClass.driver = new ChromeDriver(options);
        }
        else if (browserMode == "Chrome")
        {
        	BaseClass.driver = new ChromeDriver(options);
        }
	}
}
