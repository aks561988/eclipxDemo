package stepdefinitions;

import org.junit.Assert;
//import org.openqa.selenium.WebElement;

import com.driver.DriverFactory;
import com.pages.googlesearch.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	SearchPage googleSearch = new SearchPage(DriverFactory.getDriver());
	
	// User being navigated to google search page
	@Given("User is on the Google Search page")
	public void user_is_on_the_google_search_page_and_a_search_box_is_displayed() throws Throwable{
		Assert.assertTrue(googleSearch.isSearchBarDisplayed());
		System.out.println("Step 1 : Google Search page displayed to the user");
	}
	
	//User enters keyword
	@When("User enters {string} on the text box")
	public void user_enters_search_text_on_the_search_box(String searchText) throws Throwable{
		googleSearch.search(searchText);
		System.out.println("Step 2 : User entered " + searchText + " on the search box");
	}
	
	// First link for the search result was selected
	@And("User selects the first link in the results page") 
	public void user_clicks_on_the_first_link_available_in_the_search_results() throws Throwable{
		googleSearch.clickFirstLink();
		System.out.println("Step 3 : User clicks on the first link in result page");
	}
	
	// Check for the keyword on the displayed page
	@Then("keyword {string} should be present on the page")
	public void search_keyword_should_be_displayed_in_the_page(String searchText)throws Throwable {
			Assert.assertTrue(googleSearch.getSearchKeywordPresentInThePage(searchText));
			System.out.println("Entered text " + searchText + " is present on the page.");
		
	}

}