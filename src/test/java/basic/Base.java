package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class Base {
	WebDriver driver;
	public Properties prop;
	protected static String ID="30912";
	
	
	
	
	public Base() {
			
			prop=new Properties();
			File inputFile=new File("./src/main/java/configuration/Config.properties");
	//		FileInputStream FIS;
			try {
				FileInputStream FIS = new FileInputStream(inputFile);
				try {
					prop.load(FIS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			
		}
	
	
	
	
	
	
	
	public WebDriver intialise(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
	
		return driver;
		
	}
	
	public void logout() {
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}
	
	public void login(String user,String pass) {
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

}
