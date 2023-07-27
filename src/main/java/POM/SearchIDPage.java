package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchIDPage {
	WebDriver driver;
	public SearchIDPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a//b[text()='PIM']")
	private WebElement movePIM;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
	private WebElement moveEmployeeList;
	
	@FindBy(xpath = "//input[@id='empsearch_id']")
	private WebElement ID;
	
	@FindBy(xpath = "//input[@id='searchBtn']")
	private WebElement search;
	
	@FindBy(xpath = "//div[@id='tableWrapper']//tbody//tr//td[2]")
	private WebElement idtext;
	
	
	public WebElement move_to_PIM() {
		return  movePIM;
	}
	public WebElement move_to_EmployeeList() {
		return  moveEmployeeList;
	}
	
	public void enter_ID(String i) {
		ID.sendKeys(i);
	}
	public void click_search() {
		search.click();
	}
	public String is_idtext() {
		return idtext.getText();
	}

}
