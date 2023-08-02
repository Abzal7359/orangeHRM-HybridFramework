package POM;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BuzPage {
	public WebDriver driver;

	public BuzPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ADDpost(String m) {
		driver.findElement(By.xpath("//b[normalize-space()='Buzz']")).click();
		driver.findElement(By.xpath("//textarea[@id='createPost_content']")).sendKeys(m);
		driver.findElement(By.xpath("//input[@id='postSubmitBtn']")).click();
	}

	public boolean isPostAdded(String m)  {
		boolean s=false;
		List<WebElement> content = driver.findElements(By.xpath("//div[@id='postBody']//div[@class='postContent']"));
		for (WebElement webElementt : content) {
			String k = webElementt.getText();
			if (k.equals(m)) {
				s=true;

				driver.findElement(By.xpath("//div[@id='postFirstRowColumnThree']//a[@class='account']")).click();
				driver.findElement(By
						.xpath("//div[@id='postFirstRowColumnThree']//div[@class='submenu']//a[@class='deleteShare']"))
						.click();
				driver.findElement(By.xpath("//input[contains(@class,'submitBtn') and @id='delete_confirm']")).click();

				break;
			}
		}
//		System.out.println(s);
		return s;
	}

}
