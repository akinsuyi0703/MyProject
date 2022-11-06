package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * 
 * @author ifeol
 *
 */

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='email']")////*[@id='searchbox']/input[4]
	WebElement userName;
	
	@FindBy(name="passwd")
	WebElement passwordElement;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(xpath="//div[@class='form-group']/input[@id='email_create']")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccountButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	public HomePage login(String uname, String pass) {
		userName.sendKeys(uname);
		passwordElement.sendKeys(pass);
		signInBtn.click();
		return new HomePage();
		
	}
	
	public AddressPage login1(String uname, String pass) {
		userName.sendKeys(uname);
		passwordElement.sendKeys(pass);
		signInBtn.click();
		return new AddressPage();
		
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
	    emailForNewAccount.sendKeys(newEmail);
	    createNewAccountButton.click();
	    return new AccountCreationPage();
	}

}
