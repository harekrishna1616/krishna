package local.harekrishna;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicBrowserLaunchWithGoogle {
	WebDriver driver;
	
	@Test
	public void f() {
		//test
		String baseURL="https://www.toolsqa.com/";
		System.out.println("Launching Google chrome browser");
	//river=new ChromeDriver();
		driver.get(baseURL);
		
		
	}
	
	@BeforeMethod
	public void startWebDriver() {
		
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();		
		
	
	}

	
	
	

	}


