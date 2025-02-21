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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.DwsBase;

public class AttachExtentReport extends DwsBase implements ITestListener {
	public static ExtentSparkReporter spark=null;
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
	 test = report.createTest(name);
	 test.log(Status.INFO,name +" is OntestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, name+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "is fail");
		LocalDateTime date = LocalDateTime.now();
		String time = date.toString().replace(':','-');
		String name = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP,name+" is skip");
	}

	@Override
	public void onStart(ITestContext context) {
		File path=new File(".\\src\\test\\resources\\Reports\\MultipleTestCase.html");
		//create ExtentSparkReport
		spark=new ExtentSparkReporter(path);
		//configure ExtentSparkReport
		spark.config().setDocumentTitle("DemoWebShop");
		spark.config().setReportName("ManiKandan");
		spark.config().setTheme(Theme.DARK);
		//create ExtentReport
		report=new ExtentReports();
		//Provide System information
		report.setSystemInfo("Os","window-11");
		report.setSystemInfo("Browser","chrome-111");
		//attach the ExtentSparkReport to ExtentReport
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
