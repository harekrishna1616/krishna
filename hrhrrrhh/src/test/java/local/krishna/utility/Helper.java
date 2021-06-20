package local.krishna.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots_/"+getCurrentDayAndTime()+".png";
		try {
			FileHandler.copy(src, new File("./Screenshots/"+getCurrentDayAndTime()+".png" ));
		} catch (Exception e) {
			System.out.println("Unable to take screenshot");
		}
		return screenshotPath;
		
		
	}
	
	public static String getCurrentDayAndTime() {
		DateFormat timestampFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return timestampFormat.format(currentDate);
	}

}
