package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import base.BaseClass;

/**Class contains method to perform the search operation 
 * @author khushdeep.gupta
 */
public class Search extends BaseClass
{ 
	public WebElement searchBar = driver.findElement(By.cssSelector("input#slimSearch"));
/**
 * Method to search for a particular text in the search bar.
 * @param searchText
 */
    public void searchText(String searchText)
    {
    	searchBar.sendKeys(searchText);         
    }
    
/**
 * Method to submit the search
 */
    public void submitSearch()
    {
    	searchBar.sendKeys(Keys.ENTER);         
    }
}
