package main.java.uiAutomation.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import main.java.uiAutomation.core.Base;
import main.java.uiAutomation.pagefactory.faswebapp.SourceFuseHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.*;

public class TestCollectionOne

{
    SourceFuseHomePage sourceFuseHomePage=new SourceFuseHomePage(Base.driver);
    SoftAssert softAssert = new SoftAssert();
    ExtentTest test1 = Base.extent.createTest("Test Case 1: Try to submit without filling required fields and \"Labels\" of all the required fields printed on Console. \n");
    ExtentTest test2 = Base.extent.createTest("Test Case 2: Verify all input fields using Soft assertions. \n");
    ExtentTest test3=Base.extent.createTest("Test Case 3: Verify all input fields using Hard assertions.\n");
    ExtentTest test4=Base.extent.createTest("Test Case 4: Submit the form after filling all details properly by using XPath only. \n" );
    ExtentTest test5=Base.extent.createTest("Test Case 5: Verify DB entry after submitting the form using JDBC connection.\n");
    ExtentTest test6=Base.extent.createTest("Test Case 6: Verify Email is triggered or not after submitting the form using assertion on DB considering an email trigger column as email_sent.  \n" );

    @Test(testName = "Test Case 1: Try to submit without filling required fields and \"Labels\" of all the required fields printed on Console.")
    public void testCase1() throws InterruptedException {
        Base.driver.get("http://sfwebhtml:t63KUfxL5vUyFLG4eqZNUcuRQ@sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
        WebDriverWait wait = new WebDriverWait(Base.driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img")));
        sourceFuseHomePage.clickSubmitButton();
        if(Base.driver.getTitle().equals("SourceFuse - Form Template"))
        {
            System.out.println("Test passed, The required fields needs to filled to submit form");
        }
        else {Assert.fail("The test failed, The form was submitted without required fields being filled !");}
    }


    @Test(testName = "Test Case 2: Verify all input fields using Soft assertions.")
    public void testcase2()
    {
        softAssert.assertTrue(sourceFuseHomePage.verifyAllFields());
        test1.log(Status.PASS,"Successfull test");
    }

    @Test(testName = "Test Case 3: Verify all input fields using Hard assertions.")
    public void testCase3()
    {
        Assert.assertTrue(sourceFuseHomePage.verifyAllFields());
        test2.log(Status.PASS,"Successfull test");

    }

    @Test(testName = "Test Case 4: Submit the form after filling all details properly by using XPath only.")
    public void testCase4()
    {
        sourceFuseHomePage.fillfirstName("mohammed ajmal");
        sourceFuseHomePage.fillLastName("babu");
        sourceFuseHomePage.fillemail("ajmalbabu77@gmail.com");
        sourceFuseHomePage.fillCurrentCompany("Thrymr Software");
        sourceFuseHomePage.fillMobileNum("7989969476");
        sourceFuseHomePage.fillDateOfBirth("10/11/1995");
        sourceFuseHomePage.fillPositionApplying("Test Automation Engineer");
        sourceFuseHomePage.fillPortFolioWebsite("sample.com");
        sourceFuseHomePage.fillSalaryRequirements("5.5");
        sourceFuseHomePage.fillWhentoStart("1 month");
        sourceFuseHomePage.fillAddress("kerala,Kozhikode");
        sourceFuseHomePage.fillResume("C:\\Users\\ajmal\\Downloads\\myresume.pdf");
        sourceFuseHomePage.fillrelocate();

        test3.log(Status.PASS,"Successfull test");

    }

    @Test(testName = "Test Case 5: Verify DB entry after submitting the form using JDBC connection.\n" )
public void testcase5() throws ClassNotFoundException, SQLException {
    Connection con = DriverManager.getConnection("http://127.0.0.1:50529/","postgres","ajmal");
    Class.forName("org.postgresql.Driver");
    Statement statement=con.createStatement();
        ResultSet rs= statement.executeQuery("select formsubmitted from sourcefusetesting");

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String formsubmission = rs.getString(1);
            System. out.println("form submission sent status"+ formsubmission);
        }
        // closing DB Connection
        con.close();
    }

    @Test(testName = "Test Case 5: Verify DB entry after submitting the form using JDBC connection.\n" )
    public void testcase6() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("http://127.0.0.1:50529/","postgres","ajmal");
        Class.forName("org.postgresql.Driver");
        Statement statement=con.createStatement();
        ResultSet rs= statement.executeQuery("select emailsent from sourcefusetesting");

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String emailsent = rs.getString(1);
            System. out.println("email sent status"+ emailsent);
        }
        // closing DB Connection
        con.close();
    }
}
