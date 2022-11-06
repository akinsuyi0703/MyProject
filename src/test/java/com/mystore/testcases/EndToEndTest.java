/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.pageobjects.SigninPage;

/**
 * @author ifeol
 *
 */
public class EndToEndTest extends BaseClass{
	
	SigninPage sp;
	SearchResultPage rp;
	AddToCartPage acp;
	OrderPage op;
	LoginPage lp;
	AddressPage ap;
	ShippingPage hp;
	PaymentPage pp;
	OrderSummaryPage osp;
	OrderConfirmationPage ocp;
	
	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable {
		
		sp= new SigninPage();
		rp=sp.searchProduct("t shirt");
		acp=rp.clickOnProduct();
		acp.enterQuantity("2");
		acp.selectSize("2");
		acp.clickOnAddToCart();
		op=acp.clickOnProceedCheckOut();
		lp=op.clickOnCheckOut();
		ap=lp.login1(prop.getProperty("username"), prop.getProperty("password"));
		hp=ap.clickOnCheckOut();
		hp.checkOnTerms();
		pp=hp.clickproceedToCheckout();
		osp=pp.clickOnPaymentMethod();
		ocp=osp.clickOnconfirmOrderBtn();
		String actualMessage=ocp.validateConfirmMessage();
		String expectedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}

}
