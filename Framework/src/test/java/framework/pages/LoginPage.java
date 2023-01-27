package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy (id="user-name") WebElement uname;
	@FindBy (id="password") WebElement pass;
	@FindBy (id="login-button") WebElement loginBtn;
	
	public void LoginToWebpage(String username, String password)
	{
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginBtn.click();
	}
	
}
