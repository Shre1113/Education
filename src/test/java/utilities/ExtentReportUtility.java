package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ExtentReportUtility implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    private static final Logger logger = Logger.getLogger(ExtentReportUtility.class.getName());
    String repName;
    private static WebDriver driver; //webdriver instance
 
    
 // Static setter method for WebDriver
    public static void setWebDriver(WebDriver driver) {
        ExtentReportUtility.driver = driver;
    }


    // Method to capture screenshots
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        // Ensure the directory exists
        File destinationDir = new File(System.getProperty("user.dir") + "\\screenshots\\");
        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throwing the exception after logging it
        }

        return destination;
    }    
    public void onStart(ITestContext testContext) 
    {
        logger.info("onStart method started");

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        repName = "Test-Report-" + timeStamp + ".html";

        // Specify the location of the report
        String reportPath = "C:\\Users\\Admin\\eclipse-workspace\\FaceifyEdu\\reports\\" + repName;
        logger.info("Report Path: " + reportPath);
        sparkReporter = new ExtentSparkReporter(reportPath);

        sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
        sparkReporter.config().setReportName("Functional Testing"); // Name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Adding system information to the report
        extent.setSystemInfo("Application", "Faceify");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Users");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        logger.info("onStart method completed");
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("onTestSuccess method started");
        // Create a new test entry in the report
        test = extent.createTest(result.getName());
        test.pass("Test Passed");
        
        logger.info("Test " + result.getName() + " passed");
    }

    public void onTestFailure(ITestResult result) {
        logger.info("onTestFailure method started");
        // Create a new test entry in the report
        test = extent.createTest(result.getName());
        test.fail(result.getThrowable());
        
        // Capture and attach screenshot
        String screenshotPath;
        try {
            screenshotPath = captureScreen(result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            logger.severe("Exception while taking screenshot " + e.getMessage());
        }
        logger.info("Test " + result.getName() + " failed");
        
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("onTestSkipped method started");
        // Create a new test entry in the report
        test = extent.createTest(result.getName());
        test.skip(result.getThrowable());
        logger.info("Test " + result.getName() + " skipped");
    }

    public void onTestStart(ITestResult result) {
        // Optional: you can add code here if you want to do something at the start of each test
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: you can add code here if you want to handle tests that fail within success percentage
    }

    public void onFinish(ITestContext testContext) {
        logger.info("onFinish method started");
        // Write everything to the log file
        extent.flush();
        logger.info("Extent report flushed");
    }
}