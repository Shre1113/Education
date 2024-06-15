package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestBase.BaseTest;
import page_objects.LoginPage;

public class Log_In extends BaseTest
{
	@Test
	public void login() throws InterruptedException
	{
		
		LoginPage LP= new LoginPage(driver);
		
	
		LP.UserName();
		LP.Password();
		LP.sumbit();
		
		
	}
	
}

