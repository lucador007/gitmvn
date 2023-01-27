package framework.utility;

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
	// screenshots, alerts, frames, windows, sync issues, javascript executor
	
	public static String captureScreenshot(WebDriver driver) // Method to capture passed step screenshot
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src,new File (screenshotPath));
			System.out.println("Screenshot captured successfully.");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot >>"+e.getMessage());
		}
		return screenshotPath;
	}
	public static String getCurrentDateTime() // Method to return current date time
	{
		DateFormat dateFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return dateFormat.format(currentDate);
		
	}

}
