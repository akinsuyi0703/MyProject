/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SigninPage;

/**
 * @author ifeol
 *
 */
public class HomePageTest extends BaseClass{
	
	SigninPage sp;
	LoginPage lp;
	HomePage hp;
	
	@Test(groups = "Smoke")
	public void wishListTest() {
		
		sp= new SigninPage();
		lp=sp.clickOnSignIn(); //return the object of LoginPage reference
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));//this will return the object of homepage
		boolean result=hp.validateMyWishList();
		Assert.assertTrue(result);
	}
	@Test(groups = "Smoke")
	public void orderHistoryandDetailsTest() {
		
		sp= new SigninPage();
		lp=sp.clickOnSignIn(); //return the object of LoginPage reference
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));//this will return the object of homepage
		boolean result=hp.validateOrderHistory();
		Assert.assertTrue(result);
	}

}
