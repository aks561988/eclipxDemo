package com.pages.googlesearch;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.constants.Constants;


public class SearchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = Constants.SEARCH_BOX)
	WebElement searchBar;

	@FindBy(xpath = Constants.FIRST_LINK)
	WebElement firstLink;

	@FindBy(linkText = Constants.KEYWORD)
	WebElement searchKeywordInThePage;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));

	}

	public boolean isSearchBarDisplayed() {
		return searchBar.isDisplayed();
	}

	public void search(String key) {
		searchBar.sendKeys(key);
		System.out.println("Entered search key: " + key);
		searchBar.click();
		searchBar.sendKeys(Keys.ENTER);
	}

	public WebElement getSearchResultFirstLink() {
		return firstLink;
	}
	
	public void clickFirstLink() {
		wait.until(ExpectedConditions.visibilityOf(firstLink));
		String text = firstLink.getText();
		firstLink.click();
		System.out.println("Clicked on the first link" + text);
		
	}
	
	public String FirstLinkPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean getSearchKeywordPresentInThePage(String searchText) {
		
		return driver.getPageSource().contains(searchText);
		
	}
	
}
