/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SigninPage;

/**
 * @author ifeol
 *
 */
public class AddToCartPageTest extends BaseClass{
	
	SigninPage sp;
	SearchResultPage rp;
	AddToCartPage acp;
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest() throws InterruptedException {
		
		sp= new SigninPage();
		rp=sp.searchProduct("t shirt");
		acp=rp.clickOnProduct();
		acp.enterQuantity("2");
		acp.selectSize("2");
		acp.clickOnAddToCart();
		boolean result=acp.validateAddToCart();
		Assert.assertTrue(result);
		
		
	
		
	}

}
