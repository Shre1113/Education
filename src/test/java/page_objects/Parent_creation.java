package page_objects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Parent_creation extends BasePage 
{
	public WebDriver driver;
	public Parent_creation (WebDriver driver) 
		{
			super(driver);
		}
	@FindBy(xpath="//p[normalize-space()=\"Student Management\"]")
	WebElement student_management;
	@FindBy(xpath="//p[normalize-space()=\"Guardians\"]")
	WebElement guardians;
	@FindBy(xpath="//button[.='Add New Guardian']")
	WebElement add_new_guadian;
	@FindBy(name="guardian_name")
	WebElement guardian_name;
	@FindBy(name="mobile_number")
	WebElement mobile_number;
	@FindBy(name="email_address")
	WebElement email_address;
	@FindBy(name="occupation")
	WebElement occupation;
	@FindBy(css="input.chakra-input.css-1qjinq0")
	WebElement attachments;
	@FindBy(name="work_address")
	WebElement address;
	@FindBy(xpath="//button[.='Save']")
    WebElement save;
	public void Stu_management()
	{
		student_management.click();
	}
	public void Guardians()
	{
		guardians.click();
	}
	public void ADD_new_gurdian()
	{
		add_new_guadian.click();
	}
	public void Guardian_name()
	{
		guardian_name.sendKeys("srinivas_one");
	}
	public void Mobile_number()
	{
		mobile_number.sendKeys("8812123670");
	}
	public void Email_address()
	{
		email_address.sendKeys("srinivas_one@gmail.com");
	}
	public void Occupation()
	{
		occupation.sendKeys("Business");
	}
	public void Attachment()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(attachments));
		attachments.sendKeys("C:\\Users\\Faciefy_edu\\Screenshot 2024-03-27 105154.png");
		
	}
	public void Address()
	{
		address.sendKeys("Hyderabad");
	}
    public void Save()
    {
    	save.click();
    }
}
