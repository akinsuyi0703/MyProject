package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
	
	@FindBy(xpath="//button[@name='processAddress']/span") //span[text()='Proceed to checkout']
	WebElement proceedToCheckout;

	public AddressPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public ShippingPage clickOnCheckOut() {
		proceedToCheckout.click();
		return new ShippingPage();
	}
}
