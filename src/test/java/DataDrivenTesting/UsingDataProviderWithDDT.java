package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProviderWithDDT {
	@DataProvider(name="login")
	public Object[][] sender() throws EncryptedDocumentException, IOException{
		Reporter.log("iam an Login dataProvider",true);
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DwsLogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		int colom = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][]obj=new Object[row][colom];
		for (int i = 0; i <row; i++) {
			for (int j = 0; j <colom; j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return obj;
	}
		@Test(dataProvider = "login")
		public void reciever(String username,String password) throws InterruptedException {
			Reporter.log("iam an reciever for Login",true);
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://demowebshop.tricentis.com/");
			Thread.sleep(2000);
			driver.findElement(By.className("ico-login")).click();
			driver.findElement(By.id("Email")).sendKeys(username);
			driver.findElement(By.id("Password")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".button-1.login-button")).click();
			Thread.sleep(2000);
			driver.quit();
			Thread.sleep(5000);
		}
}
