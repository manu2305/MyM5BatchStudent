package com.crm.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Sample implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
	Reporter.log("ontestStart for "+name,true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("ontestSuccess for "+name,true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("ontestFailure for "+name,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("ontestSkipped for "+name,true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish",true);
	}

}
