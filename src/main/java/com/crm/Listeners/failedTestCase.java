package com.crm.Listeners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.DwsBase;

public class failedTestCase extends DwsBase implements ITestListener {

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
		LocalDateTime date = LocalDateTime.now();
		String time = date.toString().replace(':','-');
		String name = result.getMethod().getMethodName();
		Reporter.log("ontestFailure for "+name,true);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File from = ts.getScreenshotAs(OutputType.FILE);
		File to=new File(".\\src\\test\\resources\\ScreenShot\\"+name+time+".png");
		try {
			FileHandler.copy(from, to);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
