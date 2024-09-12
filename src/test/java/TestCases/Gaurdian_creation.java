package TestCases;

import org.testng.annotations.Test;

import TestBase.BaseTest;
import page_objects.LoginPage;
import page_objects.Parent_creation;

public class Gaurdian_creation extends BaseTest
{
	@Test
	public void Guardian() throws InterruptedException 
	{
		
	
	LoginPage LP= new LoginPage(driver);
	LP.UserName();
	LP.Password();
	LP.sumbit();
	
	Parent_creation pc= new Parent_creation(driver);
	pc.Stu_management();
	pc.Guardians();
	pc.ADD_new_gurdian();
	pc.Guardian_name();
	pc.Mobile_number();
	pc.Email_address();
	pc.Occupation();
	pc.Attachment();
	pc.Address();
	pc.Save();
	
	
	
	}
}
