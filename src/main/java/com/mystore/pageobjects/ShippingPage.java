package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{
	
	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//button[@name='processCarrier']/span") //button/span[contains(text(),'Proceed to checkout')]
	WebElement proccedToCheckOut;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void checkOnTerms() {
		terms.click();
		
	}
	
	public PaymentPage clickproceedToCheckout() {
		proccedToCheckOut.click();
		return new PaymentPage();
	}

}
