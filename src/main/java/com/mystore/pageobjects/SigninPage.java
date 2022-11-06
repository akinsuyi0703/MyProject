package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;

/**
 * @author Ifeol
 * 
 */
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SigninPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")//img[@class='logo img-responsive]")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		signInBtn.click();
		return new LoginPage();
	}	
	public boolean validateLogo() {
		return myStoreLogo.isDisplayed();
	
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle=driver.getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchProductBox.sendKeys(productName);
		searchButton.click();
		return new SearchResultPage();
	}
	
	

}
