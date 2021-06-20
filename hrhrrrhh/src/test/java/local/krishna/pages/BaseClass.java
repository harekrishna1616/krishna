package local.krishna.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import local.krishna.utility.BrowserFactory;
import local.krishna.utility.ConfigDataProvider;
import local.krishna.utility.ExcelDataProvider;
import local.krishna.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		//test test
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDayAndTime()+".html"));
	report = new ExtentReports();
	report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
	driver=BrowserFactory.launchBrowserAndStartWebApplication(config.getBrowser(),config.getURL(), driver);
	}
	
	
	@AfterClass
	public void tearDown() {
	BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			
			Helper.captureScreenshot(driver);
			try {
				System.out.println("reached to fail");
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		report.flush();
	}

}
