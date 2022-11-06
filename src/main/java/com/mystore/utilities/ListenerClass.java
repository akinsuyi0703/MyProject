package com.mystore.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.base.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener{
	
	@Override	
	public void onTestSuccess(ITestResult result) {
	    test=extent.createTest(result.getName());// create new entry in the report
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));//send the pass information	
		
		
		
	}
	@Override	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());// create new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));//send the failed information
		//captureScreenshot(result.getName()+".jpg");
		System.out.println(result.getTestContext().getName()+ "_"+result.getMethod().getMethodName());
		captureScreenshot(result.getTestContext().getName()+ "_"+result.getMethod().getMethodName()+".jpg");

		}
		
	

}
