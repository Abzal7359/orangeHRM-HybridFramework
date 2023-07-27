package POM;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RecruitmentPage {
	WebDriver driver;
	int rows;
	public RecruitmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//b[normalize-space()='Recruitment']")
	private WebElement Recruitment;
	
	@FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
	private WebElement vacancies;
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	private WebElement ADD;
	
	@FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
	private WebElement JobTittle;
	
	@FindBy(xpath = "//input[@id='addJobVacancy_name']")
	private WebElement vacancyName;
	
	@FindBy(xpath = "//input[@id='addJobVacancy_hiringManager']")
	private WebElement HiringManager;
	
	@FindBy(xpath = "//input[@id='addJobVacancy_noOfPositions']")
	private WebElement no_of_positions;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	private WebElement save;
	
	//methods
	
	public WebElement move_to_Recruitment() {
		return  Recruitment;
	}
	public WebElement move_to_vacancies() {
		return  vacancies;
	}
	public void clickAdd() {
		ADD.click();
	}
	public void selectJobTittle(String t) {
		Select JP=new Select(JobTittle);
		JP.selectByVisibleText(t);
	}
	public void enter_vacancyName(String n) {
		vacancyName.sendKeys(n);
	}
	public void enter_HiringManager(String h) {
		HiringManager.sendKeys(h);
	}
	public void enter_no_of_positions(String k) {
		no_of_positions.sendKeys(k);
	}
	public void clickSave() {
		save.click();
	}
	public boolean isVacancyAdded(String Jobname) {
		List<WebElement> r =driver.findElements(By.xpath("//div[@id='tableWrapper']//tbody//tr"));
		int rows=r.size();
		boolean l=false;
		for (int i=1;i<=rows;i++) {
			String s=driver.findElement(By.xpath("//div[@id='tableWrapper']//tbody//tr["+i+"]//td[2]")).getText();
			if(s.equals(Jobname)) {
				l=true;
				break;
			}
		}
		return l;
	}
	public void del_created_job(String Jobname) {
		List<WebElement> r =driver.findElements(By.xpath("//div[@id='tableWrapper']//tbody//tr"));
		rows=r.size();
		for (int i=1;i<=rows;i++) {
			String s=driver.findElement(By.xpath("//div[@id='tableWrapper']//tbody//tr["+i+"]//td[2]")).getText();
			if(s.equals(Jobname)) {
				driver.findElement(By.xpath("//div[@id='tableWrapper']//tbody//tr["+i+"]//td[1]")).click();
				driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
				driver.findElement(By.xpath("//*[@id=\"dialogDeleteBtn\"]")).click();

				break;
			}
		}
	}
	public boolean is_Deleted() {
		List<WebElement> s =driver.findElements(By.xpath("//div[@id='tableWrapper']//tbody//tr"));
		boolean l=false;
		if(s.size()<rows) {
			l=true;
		}
		return l;
	}
}
