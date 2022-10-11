package stepdefinition;

import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.Home;
import pages.actions.Search;
import pages.actions.SearchResults;

public class SearchSteps 
{
	Search search;
	Home home;
	SearchResults searchresults;
	
	@When("I click on the {string} icon to perform a search")
	public void i_click_on_the_icon_to_perform_a_search(String magnifierIcon) 
	{
		home = new Home();
		home.performSearch();
	}

	@When("I enter the text {string}")
	public void i_enter_the_text(String searchText) 
	{
		search = new Search();
		search.searchText(searchText);
	}
	
	@When("I submit the search")
	public void i_submit_the_search() {
		search.submitSearch();
	}

	@Then("I am taken to the search results page")
	public void i_am_taken_to_the_search_results_page() {
		searchresults = new SearchResults();
		searchresults.getPageTitle();
	}

	@Then("I am presented with at least {int} search result")
	public void i_am_presented_with_at_least_search_result(int expSearchResult) {
		assertTrue((searchresults.countSearchResults()) >= expSearchResult);
	}
}
