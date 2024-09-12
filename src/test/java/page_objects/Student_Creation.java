package page_objects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(xpath="//p[normalize-space()=\"Student Management\"]")
	WebElement student_man;
	@FindBy(xpath="//p[normalize-space()=\"Students\"]")
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
	
	@FindBy(id="react-select-2-input")
	WebElement academic_year;
	@FindBy(id="react-select-3-input")
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
	@FindBy(xpath="//span[.='Opted for Hostel']")
	WebElement opted_hostel;
	@FindBy(xpath="//button[.='Save & Next']")
	WebElement save_next;
	//Guardian details element addresses
	@FindBy(id="react-select-4-input")
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
	//list page
	@FindBy(name="searchTerm")
	WebElement search;
	
	
	
	

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
	public void name(String First_Name, String Middle_Name, String Last_Name)
	{
		FN.sendKeys(First_Name);
		MN.sendKeys(Middle_Name);
		LN.sendKeys(Last_Name);
	}
	/*public void name()
	{
		FN.sendKeys("sripriya");
		//MN.sendKeys("Parvathi");
		//LN.sendKeys("Ganesha");
	}*/
	public void mail(String Student_Email_Address)
	{
		stu_email.sendKeys(Student_Email_Address);
	}
	public void mobilenumber(String Mobile_Number)
	{
		stu_mobile.sendKeys(Mobile_Number);
	}
	public void RollNumber(String Roll_Number)
	{
		roll_num.sendKeys(Roll_Number);
	}
	public void academic_year(String Academic_Year)
	{
		//Select options= new Select(academic_year);
		//options.selectByVisibleText(Academic_Year);
		academic_year.sendKeys(Academic_Year);
	}
	public void class_section(String Class_Section)
	{
		//Select options= new Select(class_section);
		//options.selectByVisibleText(Class_Section);
		class_section.sendKeys(Class_Section);
		class_section.sendKeys(Keys.ENTER);
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
	/*public void enroll_date()
	{
		// Get today's date
        Date today = new Date();

        // Define date format
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        // Format today's date
        String formattedDate = formatter.format(today);
		enrollment_date.sendKeys(formattedDate);
		enrollment_date.sendKeys(Keys.ENTER);
		
	}*/	
	public void enroll_date(String Enrollment_Date)
	{
		enrollment_date.sendKeys(Enrollment_Date);
		//enrollment_date.sendKeys(Keys.ENTER);
		
	}
	public void gender(String Gender)
	{
		Select options= new Select(gender);
		options.selectByVisibleText(Gender);
	}
	public void dob(String Date_of_Birth)
	{
		dob.sendKeys(Date_of_Birth);
		//dob.sendKeys(Keys.ENTER);
		
		  //  JavascriptExecutor js = (JavascriptExecutor) driver;
		    //js.executeScript("arguments[0].setAttribute('value', '" + Date_of_Birth + "')", enrollment_date);
		
	}
	public void blood_grp(String Blood_Group) {
	    Select options = new Select(blood_gr);
	    options.selectByVisibleText(Blood_Group);
	}
	public void nationality(String Nationality) throws InterruptedException
	{
		nationality.sendKeys(Keys.CLEAR);
		Thread.sleep(2000);
		nationality.sendKeys(Nationality);
	}
	public void hostel(String Opted_hostel)
	{
		String a="Yes";
		if(Opted_hostel.equals(a))
		{
			opted_hostel.click();	
		}
		
	}
	public void Save_Next()
	{
		save_next.click();
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
		//Assert.assertTrue(addmore.isEnabled(), "Add More button should be enabled.");
	}
	//Actions for Guardian details
	public void guardian(String Guardian_Name) throws InterruptedException
	{
		//Select options= new Select(guardian_name);
		//Thread.sleep(2000);
		//guardian_name.sendKeys("Parent A - 7798080818");
		//guardian_name.sendKeys(Keys.ENTER);
		
		//options.selectByVisibleText("Ram");
		//options.selectByIndex(1);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(guardian_name));
	    guardian_name.sendKeys(Guardian_Name);
	    guardian_name.sendKeys(Keys.ENTER);
		
	}
	public void relation(String Relation) throws InterruptedException
	{
		Select options= new Select(relation);
		options.selectByVisibleText(Relation);
		
	}
	public void next_button()
	{
		next.click();
	}
	
	
	//Actions for Address details
	public void address(String Address_Line1, String Address_Line_2,
    		String City, String	State, String Pincode, String Country)
	{
		line_1.sendKeys(Address_Line1);
		line_2.sendKeys(Address_Line_2);
		city.sendKeys(City);
		state.sendKeys(State);
		pin.sendKeys(Pincode);
		country.sendKeys(Country);
	}
	/*public void submit_final() throws InterruptedException
	{
		Thread.sleep(2000);
		submit_final.click();
	}*/
	public void submit_final() 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(submit_final));
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
