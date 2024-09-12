package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Page_object_another_way extends BasePage {

    public WebDriver driver;

    public Page_object_another_way(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath="//p[normalize-space()=\"Student Management\"]")
    WebElement studentMan;
    @FindBy(xpath="//p[normalize-space()=\"Students\"]")
    WebElement student;
    @FindBy(xpath="//button[.='Add New Student']")
    WebElement addStudent;
    @FindBy(name="first_name")
    WebElement firstName;
    @FindBy(name="middle_name")
    WebElement middleName;
    @FindBy(name="last_name")
    WebElement lastName;
    @FindBy(name="student_email_id")
    WebElement studentEmail;
    @FindBy(name="student_mobile_number")
    WebElement studentMobile;
    @FindBy(name="custom_roll_number")
    WebElement rollNumber;
    @FindBy(id="react-select-2-input")
    WebElement academicYear;
    @FindBy(id="react-select-3-input")
    WebElement classSection;
    @FindBy(name="custom_grade")
    WebElement grade;
    @FindBy(name="custom_section_name")
    WebElement sectionName;
    @FindBy(name="custom_enrollment_date")
    WebElement enrollmentDate;
    @FindBy(name="gender")
    WebElement gender;
    @FindBy(name="date_of_birth")
    WebElement dob;
    @FindBy(name="blood_group")
    WebElement bloodGroup;
    @FindBy(name="nationality")
    WebElement nationality;
    @FindBy(name="custom_opted_for_hostel")
    WebElement optedHostel;
    @FindBy(id="submitStudentBtn")
    WebElement submit;
    @FindBy(id="react-select-4-input")
    WebElement guardianName;
    @FindBy(name="guardians.0.relation")
    WebElement relation;
    @FindBy(xpath="//button[.='Add More']")
    WebElement addMore;
    @FindBy(xpath="//button[.='Next']")
    WebElement next;
    @FindBy(xpath="//button[.='Back']")
    WebElement back;
    @FindBy(name="address_line_1")
    WebElement addressLine1;
    @FindBy(name="address_line_2")
    WebElement addressLine2;
    @FindBy(name="city")
    WebElement city;
    @FindBy(name="state")
    WebElement state;
    @FindBy(name="pincode")
    WebElement pincode;
    @FindBy(name="country")
    WebElement country;
    @FindBy(xpath="//button[.='Submit']")
    WebElement submitFinal;
    @FindBy(name="searchTerm")
    WebElement search;

    public void openStudentManagement() {
        studentMan.click();
    }

    public void openStudentList() {
        student.click();
    }

    public void openStudentCreationPage() {
        addStudent.click();
    }

    public void enterStudentDetails(String firstName, String middleName, String lastName, String email, String mobile, 
                                    String rollNumber, String academicYear, String classSection, String grade, 
                                    String sectionName, String enrollmentDate, String gender, String dob, 
                                    String bloodGroup, String nationality, String optedHostel) {
        this.firstName.sendKeys(firstName);
        this.middleName.sendKeys(middleName);
        this.lastName.sendKeys(lastName);
        this.studentEmail.sendKeys(email);
        this.studentMobile.sendKeys(mobile);
        this.rollNumber.sendKeys(rollNumber);
        new Select(this.academicYear).selectByVisibleText(academicYear);
        new Select(this.classSection).selectByVisibleText(classSection);
        this.grade.sendKeys(grade);
        this.sectionName.sendKeys(sectionName);
        this.enrollmentDate.sendKeys(enrollmentDate);
        new Select(this.gender).selectByVisibleText(gender);
        this.dob.sendKeys(dob);
        new Select(this.bloodGroup).selectByVisibleText(bloodGroup);
        this.nationality.sendKeys(nationality);
        if ("Yes".equalsIgnoreCase(optedHostel)) {
            this.optedHostel.click();
        }
    }

    public void submitStudent() {
        submit.click();
    }

    public void validateStudentCreation() {
        Assert.assertTrue(addMore.isEnabled(), "Add More button should be enabled.");
    }

    public void enterGuardianDetails(String guardianName, String relation) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.guardianName));
        this.guardianName.sendKeys(guardianName);
        this.guardianName.sendKeys(Keys.ENTER);
        new Select(this.relation).selectByVisibleText(relation);
    }

    public void clickNext() {
        next.click();
    }

    public void enterAddressDetails(String line1, String line2, String city, String state, String pincode, String country) {
        this.addressLine1.sendKeys(line1);
        this.addressLine2.sendKeys(line2);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.pincode.sendKeys(pincode);
        this.country.sendKeys(country);
    }

    public void submitFinal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitFinal));
        submitFinal.click();
    }

    public void validateFinalSubmission() {
        Assert.assertTrue(addStudent.isEnabled(), "Add Student button should be enabled.");
    }
}
