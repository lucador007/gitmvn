
  package framework.utility;
  
  import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


  
  public  class BaseClass { 
  public WebDriver driver;
  public ExcelDataProvider excel;
  public ConfigDataProvider config;
  public ExtentReports report;
  public ExtentTest logger;
  
  @BeforeSuite
  public void setupSuite()
  {
	  Reporter.log("Setting up reports and data providers.",true);
	  excel = new ExcelDataProvider();
	  config = new ConfigDataProvider();
	  
	  ExtentSparkReporter extent=new ExtentSparkReporter(new File("./Reports/FreeCRM"+Helper.getCurrentDateTime()+".html"));
	  report=new ExtentReports();
	  report.attachReporter(extent);
	  Reporter.log("Setup done for reports and data providers - Test Started",true);
  }
  @Parameters("browser")
  @BeforeClass public void setupBrowser(String browser) 
	{
	  	Reporter.log("Trying to start the browser and getting application ready",true);
		 //driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getQaURL()); 
		 driver=BrowserFactory.startApplication(driver,browser,config.getQaURL()); 
		Reporter.log("Browser and application is up and running",true);
		 }
	@AfterClass public void tearDown() 
	{ BrowserFactory.quitBrowser(driver); 
		 }
	@AfterMethod  // Method to capture failed step screenshot
	public void tearDownMethod(ITestResult result)
	{
		Reporter.log("Test is about to end",true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed >>> Report Generated",true);
	}
	
  }
  
 