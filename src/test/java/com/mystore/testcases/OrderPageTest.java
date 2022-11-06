/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SigninPage;
import com.mystore.utilities.DataSupllier;


/**
 * @author ifeol
 *
 */
public class OrderPageTest extends BaseClass{
	
	SigninPage sp;
	SearchResultPage rp;
	AddToCartPage acp;
	OrderPage op;
	
	@Test(groups="Regression", dataProvider="productData", dataProviderClass=DataSupllier.class)
	public void verifyTotalPrice(String proName, String quality, String size) throws InterruptedException {
		//public void verifyTotalPrice() throws InterruptedException {
		
		sp= new SigninPage();
		rp=sp.searchProduct(proName);
		acp=rp.clickOnProduct();
		acp.enterQuantity(quality);
		acp.selectSize(size);
		acp.clickOnAddToCart();
		op=acp.clickOnProceedCheckOut();
		Double unitPrice=op.getUnitPrice();
		Double totalPrice=op.getTotalPrice();
	   //Double totalExpectedPrice=(unitPrice*2)+2;
	    Double totalExpectedPrice=(unitPrice*(Double.parseDouble(quality)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	
			
		
		}
		
	
	}


