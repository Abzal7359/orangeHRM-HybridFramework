package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.BuzPage;
import basic.Base;

public class BuzzTest extends Base {
public WebDriver driver;
public String m="welcome to QEDGE";
public BuzPage BP;

	
	@BeforeClass
	public void setup() {
		driver=intialise(prop.getProperty("browser"));
		login(prop.getProperty("Adminmail"), prop.getProperty("Adminpassword"));
	}
	
	
	@AfterClass
	public void teardown() {

		driver.navigate().refresh();
		logout();
		driver.quit();
	}
	
	@Test
	public void postAdded_verify_delete() {
		BP=new BuzPage(driver);
		BP.ADDpost(m);
		assertTrue(BP.isPostAdded(m));
	}
	
//	@Test(priority = 0)
//	public void ADDpost() {
//		driver.findElement(By.xpath("//b[normalize-space()='Buzz']")).click();
//		driver.findElement(By.xpath("//textarea[@id='createPost_content']")).sendKeys(m);
//		driver.findElement(By.xpath("//input[@id='postSubmitBtn']")).click();
//	}
//	
//	@Test(priority = 1)
//	public void isPostAdded() throws InterruptedException {
//		
//		List<WebElement> content=driver.findElements(By.xpath("//div[@id='postBody']//div[@class='postContent']"));
//		for (WebElement webElementt : content) {
//			String k=webElementt.getText();
//			if(k.equals(m)) {
//				assertTrue(true);
//			
//				driver.findElement(By.xpath("//div[@id='postFirstRowColumnThree']//a[@class='account']")).click();
//				driver.findElement(By.xpath("//div[@id='postFirstRowColumnThree']//div[@class='submenu']//a[@class='deleteShare']")).click();
//				driver.findElement(By.xpath("//input[contains(@class,'submitBtn') and @id='delete_confirm']")).click();
//			
//				break;
//			}
//		}
//	}
	
	

}
