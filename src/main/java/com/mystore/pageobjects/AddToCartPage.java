package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutButton;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
		
	}
   
	public void enterQuantity(String quantity1) {
		quantity.clear();
		quantity.sendKeys(quantity1);
		
	}
	
	public void selectSize(String size1) {
		//size.clear();
		Select sel=new Select(size);
		sel.selectByValue(size1);
		
	}
	
	public void clickOnAddToCart() {
		addToCartButton.click();
	}
	
	public boolean validateAddToCart() throws InterruptedException {
		Thread.sleep(20000);
		return addToCartMessage.isDisplayed();
		
	}
	
	public OrderPage clickOnProceedCheckOut() throws InterruptedException {
		Thread.sleep(10000);
		proceedToCheckOutButton.click();;
		return new OrderPage();
	}
}
