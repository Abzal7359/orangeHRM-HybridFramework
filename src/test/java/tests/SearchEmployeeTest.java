package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.SearchIDPage;
import basic.Base;

public class SearchEmployeeTest extends Base {
	public WebDriver driver;
	SearchIDPage SP;
	
	@BeforeClass
	public void setup() {
		driver=intialise(prop.getProperty("browser"));
		login(prop.getProperty("Adminmail"), prop.getProperty("Adminpassword"));
	}
	
	@AfterClass
	public void teardown() {
		logout();
		driver.quit();
	}
	
	@Test
	public void serach_withID() {
		SP=new SearchIDPage(driver);
		Actions act=new Actions(driver);
		act
		.moveToElement(SP.move_to_PIM())
		.moveToElement(SP.move_to_EmployeeList())
		.click()
		.perform();
		SP.enter_ID(ID);
		SP.click_search();
		assertEquals(SP.is_idtext(), ID);
		
	}

}
