/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SigninPage;

/**
 * @author ifeol
 *
 */
public class SearchResultPageTest extends BaseClass{
	
	SigninPage sp;
	SearchResultPage rp;
	
	@Test(groups = "Smoke")
	public void pruductSearch() {
		
		sp=new SigninPage();
		rp=sp.searchProduct("t shirt");
		boolean result=rp.isProductAvailable();
		Assert.assertTrue(result);
		
	}

}
