package AssertionsMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssertMethod {
@Test
public void dws() {
	String container="maniKandan";
	String expected_result="https://demowebshop.tricentis.com/";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	String actual_result = driver.getCurrentUrl();
	assertEquals(expected_result,actual_result,"iam not in dws");
	Reporter.log("iam in dws",true);
	driver.findElement(By.id("small-searchterms")).sendKeys("Tesla cyber truck");
	WebElement search_button = driver.findElement(By.xpath("//input[@type='submit']"));
	assertTrue(search_button.isEnabled(),"search button is not enabled...");
	Reporter.log("search button is enabled...");
	search_button.click();
	assertNull(container);
	driver.close();;
}
}
