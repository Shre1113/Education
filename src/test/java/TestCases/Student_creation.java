package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Report;

import TestBase.BaseTest;
import page_objects.LoginPage;
import page_objects.Student_Creation;

public class Student_creation extends BaseTest
{
	@Test
	public void student_creation_positive() throws InterruptedException
	{
		LoginPage LP= new LoginPage(driver);
		LP.UserName();
		LP.Password();
		LP.sumbit();
		Student_Creation SM= new Student_Creation(driver); 
		SM.stu_Man();
		SM.student_list_page();
		SM.student_creation_page();
		SM.name();
		SM.mail();
		SM.mobilenumber();
		SM.RollNumber();
		SM.academic_year();
		SM.class_section();
		//SM.grade();
		//SM.Section();
		SM.enroll_date();
		SM.gender();
		SM.dob();
		SM.blood_grp();
		SM.nationality();
		SM.sumbit();
		SM.validation();
		SM.guardian();
		SM.relation();
		SM.next_button();
		SM.address();
		SM.sumbit_final();
		SM.Final_Validation();
	}
	@Test(priority = 1)
	public void student_creation_negative() throws InterruptedException
	{
		LoginPage LP= new LoginPage(driver);
		LP.UserName();
		LP.Password();
		LP.sumbit();
		Student_Creation SM= new Student_Creation(driver); 
		SM.stu_Man();
		SM.student_list_page();
		SM.student_creation_page();
		SM.sumbit();
		SM.validation_Negative();
	
	}

}
