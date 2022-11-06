package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderButton;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public OrderConfirmationPage clickOnconfirmOrderBtn() {
		confirmOrderButton.click();
		return new OrderConfirmationPage();
	}

}
