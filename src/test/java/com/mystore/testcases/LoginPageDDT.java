package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SigninPage;
import com.mystore.utilities.ExcelDataSupllier;


public class LoginPageDDT extends BaseClass{
	
	SigninPage sp;
	LoginPage lp;
	HomePage hp;
	
	@Test(dataProvider="loginData", dataProviderClass=ExcelDataSupllier.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pass) {
		logger.info("StartTestCase");
		sp= new SigninPage();
		logger.info("user is going to click on signin");
		lp=sp.clickOnSignIn(); //return the object of LoginPage reference
		logger.info("enter username and password");
		//hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));//this will return the object of homepage
		hp=lp.login(uname, pass); //get data from excel
		String actualURL=hp.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		logger.info("Verifying if user is able to login" );
		Assert.assertEquals(actualURL, expectedURL);
		logger.info("Login is succesful");
		logger.info("endTestCase");
		
		
		
	}

}
