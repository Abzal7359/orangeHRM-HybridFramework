package tests;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.*;

import POM.RecruitmentPage;
import basic.Base;

public class RecruitmentADDTest extends Base{
	public WebDriver driver;
	String Jobname="Manual Testr";
	RecruitmentPage RP;
	
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
	public void ADDvacancy() throws InterruptedException {
		RP=new RecruitmentPage(driver);
		Actions act=new Actions(driver);
		act
		.moveToElement(RP.move_to_Recruitment())
		.moveToElement(RP.move_to_vacancies())
		.click()
		.perform();
		RP.clickAdd();
		RP.selectJobTittle("QA Tester 2023");
		RP.enter_vacancyName(Jobname);
		RP.enter_HiringManager("sekhar s");
		RP.enter_no_of_positions("9");
		RP.clickSave();
		RP.move_to_vacancies().click();
		assertTrue(RP.isVacancyAdded(Jobname));	
		
	}
	@Test
	public void delete_CurrentCreatedjob() throws InterruptedException {
		RP.del_created_job(Jobname);
		assertTrue(RP.is_Deleted());
	}

}
