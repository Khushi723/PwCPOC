package stepdefinition;

import org.openqa.selenium.OutputType;
import com.aventstack.extentreports.gherkin.model.Scenario;
import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.*;

public class Hooks extends BaseClass {
	@Before
    public void setup() 
	{
		readProperties();
		initialization("Chrome");
		goToUrl(prop.getProperty("url"));	}
	
	@After
    public void tearDown(Scenario scenario) 
	{
		
		if(driver != null) {
			
		driver.quit();
		}
	}

}
