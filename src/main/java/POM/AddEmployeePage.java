package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddEmployeePage {
	WebDriver driver;
	public AddEmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a//b[text()='PIM']")
	private WebElement movePIM;
	
	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement moveEmployee;
	
	@FindBy(xpath = "//h1[normalize-space()='Add Employee']")
	private WebElement displayed;
	
	@FindBy(id = "firstName")
	private WebElement firstname;
	
	@FindBy(id="lastName")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@id='employeeId']")
	private WebElement ID;
	
	@FindBy(xpath = "//input[@id='chkLogin']")
	private WebElement loginCredinatials;
	
	@FindBy(xpath = "//input[@id='user_name']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='user_password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='re_password']")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement save;
	
	@FindBy(xpath = "//div[@id='profile-pic']//h1")
	private WebElement actuall;
	
	//Edit Employee
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement EDIT;
	
	@FindBy(xpath = "//input[@id='personal_optGender_1']")
	private WebElement Male_gender;
	
	@FindBy(xpath = "//input[@id='personal_DOB']")
	private WebElement DOB_Select;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement DOB_Month;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement DOB_Year;
	

	
	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	private WebElement country;
	
	
	//methods
	public WebElement move_to_PIM() {
		return  movePIM;
	}
	public WebElement move_to_Employee() {
		return  moveEmployee;
	}
	
	public boolean is_displayed() {
		boolean v=displayed.isDisplayed();
		return v;
	}
	
	public void enterFirstname(String f) {
		firstname.sendKeys(f);
	}
	
	public void enterLastname(String l) {
		lastname.sendKeys(l);
	}
	
	public void enterID(String id) {
		ID.clear();
		ID.sendKeys(id);
	}
	public void createLoginCredinatials() {
		loginCredinatials.click();
	}
	public void enterUsername(String u) {
		username.sendKeys(u);
	}
	public void enterPassword(String p) {
		password.sendKeys(p);
	}
	public void enterConfirmPassword(String cp) {
		confirmPassword.sendKeys(cp);
	}
	public void clickSave() {
		save.click();
	}
	public String get_actuall() {
		String a=actuall.getText();
		return a;
	}
	
	//Edit methods
	
	public void clickEDIT() {
		 EDIT.click();
	}
	public void selectMale_gender() {
		Male_gender.click();
	}
	public void clickDOB_Select() {
		DOB_Select.click();
	}
	public void selectDOB_Month(String m) {
		Select mop=new Select(DOB_Month);
		mop.selectByVisibleText(m);
	}
	
	public void selectDOB_Year(String y) {
		Select yop=new Select(DOB_Year);
		yop.selectByVisibleText(y);
	}
	
	public void selectDOB_day(String d) {
		List<WebElement> dates=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		for (WebElement webElementt : dates) {
			String day=webElementt.getText();
			if(d.equalsIgnoreCase(day)) {
				webElementt.click();
				break;
			}
		}
	}
	
	public void selectCountry(String c)  {
		Select cop=new Select(country);
		cop.selectByVisibleText(c);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
	}

}
