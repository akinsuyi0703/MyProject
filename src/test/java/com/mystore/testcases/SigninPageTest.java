package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.SigninPage;

/**
 * 
 * @author ifeol
 *
 */

public class SigninPageTest extends BaseClass{
	
	SigninPage sp;
	
    @Test(groups = "Smoke")
	public void verifyLogo() {
		sp= new SigninPage();
		boolean result=sp.validateLogo();
		Assert.assertTrue(result);
		
	}
	@Test(groups = "Smoke")
	public void verifyTitle() {
		String actTitle=sp.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
	}
	
	
}
