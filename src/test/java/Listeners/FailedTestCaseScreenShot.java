package Listeners;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBase;
@Listeners(com.crm.Listeners.failedTestCase.class)
public class FailedTestCaseScreenShot extends DwsBase{
@Test
public void digitalDownload() throws InterruptedException {
	driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
	//click shopping cart
	driver.findElement(By.className("ico-cart")).click();
	//verify the product whether is successfully added or not
	Thread.sleep(3000);
	try {
		WebElement album3rd = driver.findElement(By.xpath("(//a[text()='3rd Album'])[2]"));
		assertTrue(album3rd.isDisplayed(),"product is not added");
	    Reporter.log("product is successfully added",true);
	    driver.findElement(By.name("removefromcart")).click();
	    driver.findElement(By.name("updatecart")).click();
	} catch (Exception e) {
		Reporter.log("product is not present",true);
		fail();
	}
	
}
}
