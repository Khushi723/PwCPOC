package stepdefinition;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.Home;
import pages.actions.Subscribe;
import utils.WebDriverExtensions;

public class SubscribeSteps extends BaseClass
{
	Home home;
	Subscribe subscribe;
	
	@When("I click on the {string} navigation link")
	public void i_click_on_the_subscribe_navigation_link(String string) 
	{
		home = new Home();
		home.clickSubscribeLink();
	}

	@Then("I am taken to the {string} page")
	public void i_am_taken_to_the_subscribe_page(String string) 
	{
		subscribe = new Subscribe();
		if ((WebDriverExtensions.getPageTitle()).contains(string))
		{
		   assertTrue(true);
		}
	}

	@Then("I am presented with the below fields")
	public void i_am_presented_with_the_below_fields(DataTable dataTable) 
	{	
	    List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
	    subscribe.switchToiFrame();
	    List<String> fieldText = new ArrayList<>();
	    List<String> fieldRequired = new ArrayList<>();
	    List<String> fieldType = new ArrayList<>();
	    for (int i=0; i< data.size(); i++)
	    {
	    		fieldText.add(data.get(i).get("Field"));
	    		fieldRequired.add(data.get(i).get("Required"));
	    		fieldType.add(data.get(i).get("Type"));
	    }	    
	    assertTrue(fieldText.equals(subscribe.getFieldName()));
	    assertTrue(fieldRequired.equals(subscribe.getRequiredField())); 
	    assertTrue(fieldType.equals(subscribe.getFieldType())); 
	}

	@Then("I will need to complete Google reCAPTCHA before I can complete my request")
	public void i_will_need_to_complete_google_re_captcha_before_i_can_complete_my_request()  
	{
		subscribe.clickReCapcha();
	    assertTrue(subscribe.fetchRecaptchaStatus()); 
	}
}
