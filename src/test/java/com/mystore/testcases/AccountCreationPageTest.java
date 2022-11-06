package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SigninPage;

/**
 * @author ifeol
 *
 */
public class AccountCreationPageTest extends BaseClass{
	
	SigninPage sp;
	LoginPage lp;
	AccountCreationPage ap;
	
	@Test(groups = "Sanity")
	public void verifyCreateAccountPageTest() {
		
		sp= new SigninPage();
		lp=sp.clickOnSignIn();
		ap=lp.createNewAccount(prop.getProperty("email"));
		boolean result=ap.validateAccountCreatePage();
		Assert.assertTrue(result);
	}
	
	

}
