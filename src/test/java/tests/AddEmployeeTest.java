package tests;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import org.testng.annotations.Test;

import POM.AddEmployeePage;
import basic.Base;

public class AddEmployeeTest extends Base {
	public WebDriver driver;
	String username="Abzal273@1345";
	String password="Qedge123!@#";
	AddEmployeePage AE;
	
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
	
	@Test(priority = 0)
	public void ADDEmployee() {
		AE=new AddEmployeePage(driver);
		Actions act=new Actions(driver);
		act
		.moveToElement(AE.move_to_PIM())
		.moveToElement(AE.move_to_Employee())
		.click()
		.perform();
		assertTrue(AE.is_displayed());
		AE.enterFirstname("john");
		AE.enterLastname("mike");
		AE.enterID(ID);
		AE.createLoginCredinatials();
		AE.enterUsername(username);
		AE.enterPassword(password);
		AE.enterConfirmPassword(password);
		AE.clickSave();
		String actuall= AE.get_actuall();
		String Expected="john mike";
		assertEquals(actuall,Expected);
	}
	
	
	@Test(priority = 1)
	public void EditEmployee() throws InterruptedException {
		AE.clickEDIT();
		AE.selectMale_gender();
		AE.clickDOB_Select();
		String month="Sep";
		AE.selectDOB_Month(month);
		String Year="2001";
		AE.selectDOB_Year(Year);
		String date="26";
		AE.selectDOB_day(date);
		String desh="Indian";
		AE.selectCountry(desh);
		
		logout();
		
	}
	@Test(priority = 3)
	public void New_Employee_Login() {
		login(username, password);
		String wel=driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		assertTrue(wel.contains("john"));
	}

}
