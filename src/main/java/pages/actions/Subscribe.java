package pages.actions;

import base.BaseClass;
import utils.WebDriverExtensions;
import utils.WebElementExtensions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods to work on the Subscribe form
 * @author khushdeep.gupta
 */
public class Subscribe extends BaseClass
{
	private WebElement iframeElementSubscribeForm      = driver.findElement(By.cssSelector("iframe#sfmcform"));
	 
	/**
	 * Method to get the list of required Label WebElements on the page
	 * @return List<WebElement>
	 */
		public List<WebElement> labelElements()
		{
			return driver.findElements(By.xpath("//div[@class = 'form-row']/div[@class = 'form-group col']/label"));
		}
		
	/**
	 * Method to get the list of all the required WebElements on the page
	 * @return List<WebElement>
	 */
		private List<WebElement> inputRequiredFields()
	    {
	        return driver.findElements(By.xpath("//div[@class = 'form-row']/div[@class = 'form-group col']/label/span[@class='required']"));
	    }
	     
	/**
	 * Method to get the list of type of required WebElements on the page	
	 * @return List<WebElement>
	 */
	    private List<WebElement> inputFieldType()
	    {
	        return driver.findElements(By.xpath("//div[@class = 'form-row']/div[@class = 'form-group col']/*[@class='form-control']"));
	    }
	    
	/** 
	 * Method to get the recaptchaLogo WebElement
	 * @return WebElement
	 */
	    private WebElement recaptchaLogo()
	    {
	    	return driver.findElement(By.cssSelector("div.rc-anchor-logo-img"));
	    }

	/**
	 * Method to get the status of recaptcha Checkbox
	 * @return WebElement
	 */
	    private WebElement recaptchaStatusCheckbox()
	    { 
	    	return driver.findElement(By.cssSelector("span.recaptcha-checkbox"));
	    }
	    
	/**
	 * Method to get the recaptcha frame locator
	 * @return By
	 */
	    private By recaptchaFrameLocator ()
	    {
	    	return By.cssSelector("iframe[title = 'reCAPTCHA']");
	    }
/**
 * Method to switch to the Subscribe form iframe
 */
    public void switchToiFrame()
    {
        driver.switchTo().frame(iframeElementSubscribeForm);
    }
 
/**
 * Generalized method to get the Label Field Names of all the required Fields of the Form
 * @return
 */
    public List<String> getFieldName()
    {
      	List<String> labelText = new ArrayList<>();
    	for (int i=0;i<labelElements().size(); i++)
    	{
    		labelText.add(StringUtils.chop(labelElements().get(i).getText()));
    	}
    	return labelText;
    }

/**
 * Generalized method to get the Required attribute of all the fields of the Form
 * @return
 */
    public List<String> getRequiredField()
    {
    	List<String> requiredFields = new ArrayList<>();
    	for (int i=0;i<inputRequiredFields().size(); i++)
    	{
    		requiredFields.add(String.valueOf(inputRequiredFields().get(i).isDisplayed()));
    	}
    	return requiredFields;
    }

/**
 * Generalized method to get the type of all the required fields of the Form
 * @return
 */
    public List<String> getFieldType()
    {
    	List<String> fieldType = new ArrayList<>();
    	for (int i=0;i<inputFieldType().size(); i++)
    	{
    		String tagName = inputFieldType().get(i).getTagName();
    		if(tagName.equals("input")) {
    			fieldType.add(inputFieldType().get(i).getAttribute("type"));
    		}
    		else if (tagName.equals("select")) {
    			fieldType.add("dropdown");
    		}
    	}
    	return fieldType;
    }                  

/**
 * Method to perform a click on the Recaptcha logo
 */
    public void clickReCapcha()
    {
    	WebElementExtensions.scrollToElement(driver.findElement(recaptchaFrameLocator()));
    	WebDriverExtensions.FrameToBeAvailableToSwitch(recaptchaFrameLocator(), Duration.ofSeconds(60));
        WebDriverExtensions.ElementToBeClickable(recaptchaLogo(), Duration.ofSeconds(60));
        WebElementExtensions.clickElement(recaptchaLogo());
    }

/**
 * Method to get the status of recaptcha checkbox
 * @return boolean
 */
    public boolean fetchRecaptchaStatus()
    {
       boolean bool = Boolean.parseBoolean(recaptchaStatusCheckbox().getAttribute("aria-checked"));
       return bool;  
    }
}