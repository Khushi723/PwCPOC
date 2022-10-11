package pages.actions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BaseClass;
import utils.WebDriverExtensions;

/**
 * Contains methods for the Search Results page
 * @author khushdeep.gupta
 *
 */
public class SearchResults extends BaseClass
{
	public By searchResultsLocator = By.cssSelector("h2[data-v-fb4d80f8]");
	public List<WebElement> searchResults   = driver.findElements(By.cssSelector("a[data-v-fb4d80f8]"));
/** 
 * Method to get the page title
 * @return
 */
	public String getPageTitle()
    {
    	WebDriverExtensions.ElementIsVisible(searchResultsLocator, Duration.ofSeconds(60)); // The search operation is slow which takes apprx time to search from 150-200 sec. So the wait time is higher here. 
    	return driver.getTitle();       
    }
/**
 * Method to count the number of search results
 * @return
 */
	public int countSearchResults()
    {       
       return searchResults.size(); 
    }
}
