package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class Topics extends BaseClass {

	private WebElement topicsHeaderElement = driver.findElement(By.cssSelector("div.col-xs-8 > h2.collections-title"));
	
	public String getTopicsPageTitle()
	{
		return topicsHeaderElement.getText();
	}
	
	
}
