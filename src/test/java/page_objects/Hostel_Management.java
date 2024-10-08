package page_objects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hostel_Management extends BasePage
{
	public Hostel_Management (WebDriver driver)
	{
		super(driver);
	}
	
	//Hostel Managemet
	@FindBy(xpath="//p[.='Hostel Management']")
	WebElement Hostel_management;
	@FindBy(xpath="//p[.='Hostel Dashboard']")
	WebElement Hostel_dashboard;
	@FindBy(xpath="//p[.='Hostel Group']")
	WebElement Hostel_group;
	@FindBy(xpath="//p[normalize-space()=\"Allotment\"]")
	WebElement Allotment;
	@FindBy(xpath="//button[.='+ Add']")
	WebElement Add;
	@FindBy(xpath="//button[.='Single Allotment']")
	WebElement Single_allotment;
	@FindBy(xpath="//button[.='Bulk Allotment']")
	WebElement Bulk_allotment;
	@FindBy(xpath="//input[@id=\"react-select-2-input\"]")
	WebElement Hostel_allotment_year;
	@FindBy(xpath="//button[.='Get Students']")
	WebElement Get_student;
	@FindBy(name="hostel")//selection
	WebElement Hostel;
	@FindBy(name="floor")//selection
	WebElement Floor;
	@FindBy(name="room")//selection
	WebElement Room;
	@FindBy(name="searchTerm")
	WebElement Search_term;
	@FindBy(xpath="//div[@class='chakra-input__right-element css-15xzr1']")
	WebElement Search_button;
	@FindBy(xpath="(//span[@class='chakra-checkbox__control css-1ydjfm6'])[2]")
	WebElement Student_selection;
	@FindBy(xpath="//button[.='Save']")
	WebElement Save;
	
	public void hostel_management()
	{
		Hostel_management.click();
		
	}
	public void allotment() throws AWTException, InterruptedException
	{
		/*Point a =Allotment.getLocation();
        int x=a.getX();
        int y=a.getY();
        System.out.println(x+" "+y);*/
		
		//Robot keys= new Robot ();
		//keys.mouseWheel(1000);
		//Thread.sleep(3000);
		//Actions action= new Actions(driver);
		//all.click(Allotment);
		//System.out.println();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement autoPopulatedField = wait.until(
            //ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Allotment']")));
        //all.moveByOffset(62, 659).build().perform();
		//action.moveToElement(Allotment, 62, 659).click().perform();
        //Allotment.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Allotment);
       
		
	}
	public void add()
	{
		Add.click();
		Bulk_allotment.click();
	}
	public void hostel_allotment_year(String Allotment_year)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//System.out.println("Help");
		Hostel_allotment_year.sendKeys(Allotment_year);
		Hostel_allotment_year.sendKeys(Keys.ENTER);
	}
	
	public void get_student()
	{
		Get_student.click();
	}
	public void hostel(String Hostel_name)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select options= new Select(Hostel);
		options.selectByVisibleText(Hostel_name);
	}
	public void floor(String Floor_name)
	{
		Select options= new Select(Floor);
		options.selectByVisibleText(Floor_name);
	}
	public void room(String Room_name)
	{
		Select options= new Select(Room);
		options.selectByVisibleText(Room_name);
	}
	public void search(String Student_name)
	{
		Search_term.sendKeys(Student_name);
		Search_button.click();
	}
	public void student_selection() throws AWTException
	{
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Student_selection.sendKeys(Keys.SPACE);
		Student_selection.click();
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Student_selection);
	*/}
	public void save()
	{
		Save.click();
	}
	

}
