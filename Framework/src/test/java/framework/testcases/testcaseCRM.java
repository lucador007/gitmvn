package framework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.pages.LoginPage;
import framework.utility.BaseClass;
import framework.utility.ExcelDataProvider;
import framework.utility.Helper;


public class testcaseCRM extends BaseClass
{
	  @Test 
	  public void LoginApp() 
	  {
		logger =  report.createTest("Login to CRM test");
	  LoginPage login = PageFactory.initElements(driver,LoginPage.class);
		logger.info("Starting Application.");
	  login.LoginToWebpage(excel.getStringData("Login", 0, 0), excel.getStringData(0, 0, 1)); 
	  	logger.pass("Login Success.");
	  	Reporter.log("This log is in test method");
	  }
	  @Test 
	  public void LoginApp1() 
	  {
		logger =  report.createTest("Logout of CRM");
	  	logger.info("Logout Application.");
	  	logger.log(Status.INFO, "Info Log added using log method");
	  	logger.skip("skipped log");
	  	logger.fail("Logout Failed");
	  }
	 
}
