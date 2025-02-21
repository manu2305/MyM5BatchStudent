package ExtentReportMethod;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
@Test
public void reports() {
	File path=new File(".\\src\\test\\resources\\Reports\\sampleReport.html");
	//create ExtentSparkReport
	ExtentSparkReporter spark=new ExtentSparkReporter(path);
	//configure ExtentSparkReport
	spark.config().setDocumentTitle("DemoWebShop");
	spark.config().setReportName("ManiKandan");
	spark.config().setTheme(Theme.DARK);
	//create ExtentReport
	ExtentReports report=new ExtentReports();
	//Provide System information
	report.setSystemInfo("Os","window-11");
	report.setSystemInfo("Browser","chrome-111");
	//attach the ExtentSparkReport to ExtentReport
	report.attachReporter(spark);
	//create extentTest
	ExtentTest test = report.createTest("reports");
	//use flush
	report.flush();
}
}
