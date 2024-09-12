package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BaseTest;
import page_objects.LoginPage;
import page_objects.Student_Creation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Student_onboard extends BaseTest
{
	Student_Creation studentCreation;

    @Test(dataProvider = "StudentData")
    public void studentdata(
    		String First_Name, String Middle_Name, String Last_Name, 
    		String Student_Email_Address, String Mobile_Number,
    		String Roll_Number, String Academic_Year, String Class_Section,
    		String Grade, String Section, String Enrollment_Date,
    		String Gender, String Date_of_Birth, String	Blood_Group,
    		String Nationality,	String Opted_hostel, String Guardian_Name, String Relation,
    		String Address_Line1, String Address_Line_2,
    		String City, String	State, String Pincode, String Country) throws InterruptedException, AWTException 
    {
    	LoginPage LP= new LoginPage(driver); 
		LP.UserName();
		LP.Password();
		LP.sumbit();
    	
    	// Initialize the page object
        studentCreation = new Student_Creation(driver);
        studentCreation.stu_Man();
        studentCreation.student_list_page();
        studentCreation.student_creation_page();
        studentCreation.name(First_Name, Middle_Name, Last_Name);
        studentCreation.mail(Student_Email_Address);
        studentCreation.mobilenumber(Mobile_Number);
        studentCreation.RollNumber(Roll_Number);
        studentCreation.academic_year(Academic_Year);
        studentCreation.class_section(Class_Section);
        studentCreation.enroll_date(Enrollment_Date);	
        studentCreation.gender(Gender);
        studentCreation.dob(Date_of_Birth);
        studentCreation.blood_grp(Blood_Group);
        //studentCreation.nationality(Nationality);
        studentCreation.hostel(Opted_hostel);
        studentCreation.Save_Next(); 
        studentCreation.validation();
        studentCreation.guardian(Guardian_Name);
        studentCreation.relation(Relation);
        studentCreation.next_button();
        studentCreation.address(Address_Line1, Address_Line_2, City, State, Pincode, Country);
        studentCreation.submit_final();
        
        
        
    }

    @DataProvider(name = "StudentData")
    public Object[][] getData() throws IOException 
    {
        String excelFilePath = "C:\\Users\\Admin\\eclipse-workspace\\FaceifyEdu\\Excels\\student_data.xlsx";
        String sheetName = "Sample";

        // Set the Excel file and sheet before getting the data
        ExcelUtils.setExcelFile(excelFilePath, sheetName);

        int rowCount = ExcelUtils.getRowCount();
        int colCount = ExcelUtils.getColCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) 
        {
            for (int j = 0; j < colCount; j++) 
            {
                data[i - 1][j] = ExcelUtils.getCellData(i, j);
            }
        }

        return data;
    }

   
}
