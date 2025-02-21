package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.pom.DwsLogin;

public class Login {
@Test
public void main() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	DwsLogin dws=new DwsLogin(driver);
	Thread.sleep(1000);
    dws.loginLink();
    dws.userName("admin01@gmail.com");
    dws.password("admin01");
    dws.rememberMe();
    dws.loginButton();
}
}
