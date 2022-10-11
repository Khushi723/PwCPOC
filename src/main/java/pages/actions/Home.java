package pages.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BaseClass;
import utils.WebElementExtensions;

/**
 * Contains the methods which are applicable on the Home page of the website.
 * @author khushdeep.gupta
 */
public class Home extends BaseClass
{
	private List<WebElement> divArticleColumns = driver.findElements(By.cssSelector("div.collectionv2__content > div[class^='headline_column']"));
	private WebElement siteTitle = driver.findElement(By.cssSelector("meta[property='og:title']"));
	private WebElement siteName = driver.findElement(By.cssSelector("meta[property='og:site_name']"));
	private WebElement subscribeLink  = driver.findElement(By.cssSelector("a[aria-controls = 'subscribe-subnav-4']"));
	private WebElement searchMagnifierIcon = driver.findElement(By.cssSelector("div.nav-search > button.search-hide"));

	/**
	 * Generalized method to return the list of Column webelements on the Home page. 
	 * @param columnName
	 * @return List<WebElement>
	 */
	private List<WebElement> articlesColumns(String columnName)
	    {
	        try
	        {
	              return driver.findElements(By.cssSelector("div.collectionv2__content > div[class='headline_"+ columnName + "'] > article"));
	        }
	        catch (Exception ex)
	        {
	            throw ex;
	        }
	    }
	
	private WebElement topicsElement()
	{
		return driver.findElement(By.xpath("//div[@class='text-component ']/h3[text()='Topics']"));
	}
	
	private WebElement topicLink(String topicName)
	{
		return driver.findElement(By.xpath("//li/a[text()='"+topicName +"']"));
	}
/**
 * Method to return the complete Website name
 * @return String
 */
	public String getCompleteWebSiteName()
	{
		return (siteName.getAttribute("content")).concat(siteTitle.getAttribute("content"));
	}
	
/**
 * Method to count the number of columns of articles on the page. 
 * @return
 */
	public int countNumberOfColumns()
	{
		return divArticleColumns.size();
	}
	
/**
 * Generalized method to count the number of columns in any column
 * @param columnName
 * @return int
 */
	public int countColumnArticles(String columnName)
	{
		return articlesColumns(columnName).size();
	}
	
/**
 * Method to click on the Subscribe link
 */
	
	public void clickSubscribeLink()
    {
		subscribeLink.click();
    }
	
/** Method to click on the Search icon
 */
	
	 public void performSearch()
	    {
		 	searchMagnifierIcon.click();        
	    }
	 
	 public void scrollToTopics()
	 {
		 WebElementExtensions.scrollToElement(topicsElement());
	 }
	 
	 public void clickOnTopics(String topicName)
	 {
		 topicLink(topicName).click();
	 }
}
