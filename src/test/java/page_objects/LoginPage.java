package page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage

{
	public WebDriver driver;
	public LoginPage (WebDriver driver) 
		{
			super(driver);
		}
	
	
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//button[.='Login']")
	WebElement login;
	
	
	public void UserName() throws InterruptedException
	{
		if(username.isEnabled())
		{
		username.sendKeys("school_admin@rnit.com");
		System.out.println("Enabled");
		}
		else
		{
			System.out.println("Not enabled");
		}
	}
	public void Password()
	{
		password.click();
		password.sendKeys("Rnit@123");
	}
	public void sumbit()
	{
		login.click();
	}
	
	
}



