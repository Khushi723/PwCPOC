package stepdefinition;

import static org.junit.Assert.assertEquals;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.Home;
import pages.actions.Topics;
import utils.WebDriverExtensions;

public class HomeSteps extends BaseClass
{
	Home home;
	Topics topics;
	
	@Given("I navigate to the PwC Digital Pulse website")
	public void i_navigate_to_the_pw_c_digital_pulse_website() 
	{
		home = new Home();
		boolean flag = false;
		if((home.getCompleteWebSiteName()).equals("PwC Digital Pulse"))
				{
					flag = true;
				}
	}
		
	@When("I am viewing the {string} page")
	public void i_am_viewing_the_home_page(String string) 
	{
		boolean flag = false;
		if((WebDriverExtensions.getPageTitle()).equals("Digital Pulse"))
				{
					flag = true;
				}
	}

	@Then("I am presented with {int} columns of articles")
	public void i_am_presented_with_columns_of_articles(int expNoOfColumns)
	{
		assertEquals(expNoOfColumns, home.countNumberOfColumns());
	}

	@Then("The {string} column is displaying {int} articles")
	public void the_column_is_displaying_articles(String string, int expColumnArticles) 
	{
		String columnName;
		if(string.equals("left"))
		{
			columnName = "column2";
		}
		
		else if (string.equals("middle"))
		{
			columnName = "column1";
		}
		else 
		{
			columnName = "column3";
		}
		assertEquals(expColumnArticles, home.countColumnArticles(columnName));
	}
	
	@Then("Scroll down to the {string} section")
	public void scroll_down_to_the_section(String topics) {
	    home.scrollToTopics();
	}

	@Then("Click on the {string}")
	public void click_on_the(String topicName) {
	    home.clickOnTopics(topicName);
	}

	@Then("user is navigated to the {string} page")
	public void user_is_navigated_to_the_page(String topicsPage) {
	    topics = new Topics();
	    topics.getTopicsPageTitle();
	}	
}
