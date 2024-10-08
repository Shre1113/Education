package TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataDriven.ExcelUtils;
import TestBase.BaseTest;
import page_objects.Hostel_Management;
import page_objects.LoginPage;
import page_objects.Student_Creation;

public class Hostel_BulkAllotment extends BaseTest
{
	Hostel_Management HM;

	    @Test(dataProvider = "HostelData")
	    public void hosteldata(String Allotment_year, String Hostel_name, String Floor_name, 
	    		String Room_name, String Student_name) throws InterruptedException, AWTException
	    		{
	    	LoginPage LP= new LoginPage(driver); 
			LP.UserName();
			LP.Password();
			LP.sumbit();
	    	
	    	// Initialize the page object
	        HM= new Hostel_Management(driver);
	        HM.hostel_management();
	        HM.allotment();
	        HM.add();
	        HM.hostel_allotment_year(Allotment_year);
	        HM.get_student();
	        HM.hostel(Hostel_name);
	        HM.floor(Floor_name);
	        HM.room(Room_name);
	        HM.search(Student_name);
	        HM.student_selection();
	        HM.save();
	        
	        
	    }

	    @DataProvider(name = "HostelData")
	    public Object[][] getData() throws IOException 
	    {
	        String excelFilePath = "C:\\Users\\Admin\\eclipse-workspace\\FaceifyEdu\\Excels\\HostelBulkAllotment.xlsx";
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



