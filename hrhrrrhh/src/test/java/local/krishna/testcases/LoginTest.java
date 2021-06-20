package local.krishna.testcases;

import org.testng.annotations.Test;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import local.krishna.pages.BaseClass;
import local.krishna.pages.LoginPage;
import local.krishna.utility.ExcelDataProvider;
//import local.krishna.utility.BrowserFactory;

public class LoginTest extends BaseClass{
	
	
	
	@Test
	public void mainTest() {
		
		//driver=BrowserFactory.launchBrowserAndStartWebApplication("chrome", "https://www.google.com", driver);
		//System.out.println(driver.getTitle());
		//driver.quit();
		//logger=report.createTest("Login to CRM");
		logger=report.createTest("login to crm");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Strting application");
		loginPage.loginToWebApp(excel.getStringData("Sheet1", 0, 0),excel.getStringData("Sheet1", 0, 1));
		logger.pass("Login successfully");
	}

}
