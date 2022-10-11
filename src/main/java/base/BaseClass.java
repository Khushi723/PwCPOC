package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import utils.BrowserOptionsManager;

/** Contains the methods to initialize the browser and other settings.
* 	Navigates the user to the specified URL.
*/
public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	
/** To initialize the browser, maximizes and deletes the cookies
 * @param browser
 */
	public static void initialization(String browser)
	{
		switch (browser)
        {
            case "ChromeHeadless":
                BrowserOptionsManager.chromeOptions(browser);
                break;
            case "Chrome":
                BrowserOptionsManager.chromeOptions(browser);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.manage().deleteAllCookies();
                break;
        }
	}
	
/** To navigate to the URL specified in the configuration.properties file.
 * @param url
 */
	public static void goToUrl(String url)
    {
        driver.navigate().to(url);
    }
	
/**	reads the application configuration data from configuration.properties and returns the properties instance.
 * @return prop
 */
	public static Properties readProperties() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/config/Configuration.properties");
            
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
