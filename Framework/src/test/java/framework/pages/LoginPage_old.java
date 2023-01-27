package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_old 
{
	WebDriver driver;
	public LoginPage_old(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	//Page Elements
	By uname = By.id("user-name");
	By pass = By.id("password");
	By loginBtn = By.id("login-button");
	//Set Element Values * design click events on buttons
	public void setUname(String username) 
	{
		driver.findElement(uname).sendKeys(username);
	}
	public void setPassword(String password) 
	{
		driver.findElement(pass).sendKeys(password);
	}
	public void clickLoginBtn()
	{
		driver.findElement(loginBtn).click();
	}
	public void LoginToWebpage(String username, String password) 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUname(username);
		setPassword(password);
		clickLoginBtn();
	}
	
}
