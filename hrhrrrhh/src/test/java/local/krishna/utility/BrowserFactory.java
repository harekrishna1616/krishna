package local.krishna.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	
	public static WebDriver launchBrowserAndStartWebApplication(String browserName, String appURL, WebDriver driver ) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();	
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.chromedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("This browser is not supported");
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		
	}
	

}
