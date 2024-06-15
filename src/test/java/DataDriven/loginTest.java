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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginTest extends BaseTest
{


    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException, AWTException 
    {
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[.='Login']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement successMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[.='Invalid login credentials']")));

        // Validate the success message
        String expectedMessage = "Invalid login credentials";
        String actualMessage = successMessageElement.getText();
        System.out.println("Hey" + actualMessage);                // have to check
        
     // Assert that the actual message matches the expected message
        Assert.assertEquals("The success message should match the expected message", expectedMessage, actualMessage);

        
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException 
    {
        String excelFilePath = "C:\\Users\\Admin\\eclipse-workspace\\FaceifyEdu\\Excels\\Login_page_TestData.xlsx";
        String sheetName = "Log_in";

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
