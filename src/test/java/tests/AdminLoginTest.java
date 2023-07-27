package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import POM.LoginPage;
import basic.Base;

public class AdminLoginTest extends Base {
	public WebDriver driver;

	
	@BeforeClass
	public void setup() {
		driver=intialise(prop.getProperty("browser"));

	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	@Test(priority = 0)
	public   void AdminLogin() {
		login(prop.getProperty("Adminmail"), prop.getProperty("Adminpassword"));
		logout();
		
	}
	
}
	


