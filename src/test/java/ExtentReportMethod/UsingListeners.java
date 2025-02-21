package ExtentReportMethod;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBase;

public class UsingListeners extends DwsBase {
@Test
public void main1() {
	Reporter.log("main1",true);
}
@Test(timeOut = 1000)
public void main2() throws InterruptedException {
	Reporter.log("main2",true);
	Thread.sleep(2000);
}
@Test(dependsOnMethods = "main2")
public void main3() {
	Reporter.log("main3",true);
}
}
