package page_objects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Student_Creation extends BasePage

{
	public WebDriver driver;
	public Student_Creation (WebDriver driver) 
		{
			super(driver);
		}
    //page directions element addresses
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/aside[1]/nav[2]/div[1]/ul[1]/li[1]/div[1]/span[1]")
	WebElement student_man;
	@FindBy(xpath="//a[@id=\"sub-menu-51\"]")
	WebElement student;
	@FindBy(xpath="//button[.='Add New Student']")
	WebElement add_student;
	//student details element addresses
	@FindBy(name="first_name")
	WebElement FN;
	@FindBy(name="middle_name")
	WebElement MN;
	@FindBy(name="last_name")
	WebElement LN;
	@FindBy(name="student_email_id")
	WebElement stu_email;
	@FindBy(name="student_mobile_number")
	WebElement stu_mobile;
	@FindBy(name="custom_roll_number")
	WebElement roll_num;
	@FindBy(name="custom_academic_year")
	WebElement academic_year;
	@FindBy(name="custom_student_group")
	WebElement class_section;
	@FindBy(name="custom_grade")
	WebElement grade;
	@FindBy(name="custom_section_name")
	WebElement section_name;
	@FindBy(name="custom_enrollment_date")
	WebElement enrollment_date;
	@FindBy(name="gender")
	WebElement gender;
	@FindBy(name="date_of_birth")
	WebElement dob;
	@FindBy(name="blood_group")
	WebElement blood_gr;
	@FindBy(name="nationality")
	WebElement nationality;
	@FindBy(id="submitStudentBtn")
	WebElement sumbit;
	//Guardian details element addresses
	@FindBy(name="guardians.0.guardian")
	WebElement guardian_name;
	@FindBy(name="guardians.0.relation")
	WebElement relation;
	@FindBy(xpath="//button[.='Add More']")
	WebElement addmore;
	@FindBy(xpath="//button[.='Next']")
    WebElement next;
	@FindBy(xpath="//button[.='Back']")
	WebElement back;
	//Address details element addresses
	@FindBy(name="address_line_1")
	WebElement line_1;
	@FindBy(name="address_line_2")
	WebElement line_2;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="pincode")
	WebElement pin;
	@FindBy(name="country")
	WebElement country;
	@FindBy(xpath="//button[.='Submit']")
	WebElement submit_final;
	
	
	

	public void stu_Man()
	{
		student_man.click();
	}
	public void student_list_page()
	{
		student.click();
	}
	public void student_creation_page()
	{
		add_student.click();
	}
	//Actions for student details
	public void name()
	{
		FN.sendKeys("Maha");
		MN.sendKeys("Parvathi");
		LN.sendKeys("Ganesha");
	}
	public void mail()
	{
		stu_email.sendKeys("maha@student.com");
		
	}
	public void mobilenumber()
	{
		stu_mobile.sendKeys("7746957103");
	}
	public void RollNumber()
	{
		roll_num.sendKeys("Shiva_02");
	}
	public void academic_year()
	{
		Select options= new Select(academic_year);
		options.selectByVisibleText("2024-25");
	}
	public void class_section()
	{
		Select options= new Select(class_section);
		options.selectByVisibleText("Class-2-A-2024-25");
	}
	/*public void grade()
	{
		 // Wait for the auto-population to complete
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement autoPopulatedField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("custom_grade")));

        // Get the value of the auto-populated field
        String autoPopulatedValue = autoPopulatedField.getAttribute("grade");

        // Assert that the value is as expected
        Assert.assertEquals(autoPopulatedValue, "Class X", "The auto-populated value is incorrect!");
		}
	public void Section()
	{
		 // Wait for the auto-population to complete
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement autoPopulatedField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("custom_section_name")));

        // Get the value of the auto-populated field
        String autoPopulatedValue = autoPopulatedField.getAttribute("section_name");

        // Assert that the value is as expected
        Assert.assertEquals(autoPopulatedValue, "A", "The auto-populated value is incorrect!");
	}*/
	public void enroll_date()
	{
		// Get today's date
        Date today = new Date();

        // Define date format
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        // Format today's date
        String formattedDate = formatter.format(today);
		enrollment_date.sendKeys(formattedDate);
		enrollment_date.sendKeys(Keys.ENTER);
		
	}
	
	public void gender()
	{
		Select options= new Select(gender);
		options.selectByVisibleText("Male");
	}
	public void dob()
	{
		dob.sendKeys("14-02-2000");
	}
	public void blood_grp()
	{
		Select options= new Select(blood_gr);
		options.selectByVisibleText("O+");
	}
	public void nationality()
	{
		nationality.sendKeys("Indian");
	}
	public void sumbit()
	{
	sumbit.click();
    }
	public void validation()
	{
		if(addmore.isEnabled()==true)
		{
			System.out.println("Student details are updated, now you can continue with parent details");
		}
		else
		{
			System.out.println("please look at student details, somethine went wrong");
		}
		
	}
	//Actions for Guardian details
	public void guardian() throws InterruptedException
	{
		Select options= new Select(guardian_name);
		Thread.sleep(2000);
		
		//options.selectByVisibleText("Ram");
		options.selectByIndex(1);
	}
	public void relation() throws InterruptedException
	{
		Select options= new Select(relation);
		Thread.sleep(2000);
		//options.selectByVisibleText("Father");
		options.selectByIndex(1);
	}
	public void next_button()
	{
		next.click();
	}
	
	
	//Actions for Address details
	public void address()
	{
		line_1.sendKeys("201");
		line_2.sendKeys("Near Br-Hitech Theatre");
		city.sendKeys("Hyderabad");
		state.sendKeys("Telangana");
		pin.sendKeys("500081");
		country.sendKeys("India");
	}
	public void sumbit_final() throws InterruptedException
	{
		Thread.sleep(2000);
		submit_final.click();
	}
	public void Final_Validation()
	{
		if(add_student.isEnabled()==true)
{
	System.out.println("Student successfully created");
}
		else
		{
			System.out.println("Something went wrong");
		}

	}
	public void validation_Negative()
	{
		if(addmore.isEnabled()==true)
		{
			System.out.println("User Successfully stuck in the student deatils entry page");
		}
		else
		{
			System.out.println("Somethine went wrong");
		}
		
	}
	
	
}
