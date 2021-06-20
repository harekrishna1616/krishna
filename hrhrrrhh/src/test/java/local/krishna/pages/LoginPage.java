package local.krishna.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	/*public LoginPage(WebDriver lDriver) {
		this.driver=lDriver;
	}*/
	
	@FindBy(name="uid2") WebElement userName;
	@FindBy(name="password") WebElement password;
	@FindBy(name="btnLogin") WebElement loginButton;
	
	public void loginToWebApp(String usrnm, String pswd) {
		userName.sendKeys(usrnm);
		password.sendKeys(pswd);
		loginButton.click();
	}
	
	
}
