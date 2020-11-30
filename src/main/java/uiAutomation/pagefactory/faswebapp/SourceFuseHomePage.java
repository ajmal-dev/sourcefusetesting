package main.java.uiAutomation.pagefactory.faswebapp;

import main.java.uiAutomation.core.Base;
import main.java.uiAutomation.core.BrowserFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SourceFuseHomePage
{
    BrowserFunctions browserFunctions=new BrowserFunctions();
    public SourceFuseHomePage(WebDriver webDriver)
    {
        this.webDriver=webDriver;
    }
    WebDriver webDriver;
    private By firstName=By.xpath("//label[contains(text(),'First Name ')]//following::input[1]");
    private By lastName=By.xpath("//label[contains(text(),'Last Name ')]//following::input[1]");
    private By email=By.xpath("//label[contains(text(),'Email ')]//following::input[1]");
    private By CurrentCompany=By.xpath("//label[contains(text(),'Current Company ')]//following::input[1]");
    private By MobileNumber=By.xpath("//label[contains(text(),'Mobile No. ')]//following::input[1]");
    private By DateOfBirth=By.xpath("//label[contains(text(), 'Date of Birth ')]//following::input[1]");
    private By PositionApplying=By.xpath("//label[contains(text(), 'Position you are applying for ')]//following::input[1]");
    private By PortFolioWebsite=By.xpath("//label[contains(text(), 'Portfolio Website ')]//following::input[1]");
    private By SalaryRequirements=By.xpath("//label[contains(text(), 'Salary requirements ')]//following::input[1]");
    private By WhentoStart=By.xpath("//label[contains(text(), 'When can you start?')]//following::input[1]");
    private By Address=By.xpath("//label[contains(text(), 'Address')]//following::textarea[1]");
    private By resume=By.xpath("//input[@id='resume']");
    private By relocate=By.xpath("//label[contains(text(), 'Are you willing to relocate? ')]//following::input[1]");
    private By submit=By.xpath("//button[@type='submit']");

    public void clickSubmitButton()
    {
        browserFunctions.click(submit);
    }

    public void fillfirstName(String data)
    {
        browserFunctions.enterData(firstName,data);
    }
    public void fillLastName(String data)
    {
        browserFunctions.enterData(lastName,data);
    }
    public void fillemail(String data)
    {
        browserFunctions.enterData(email,data);
    }
    public void fillCurrentCompany(String data)
    {
        browserFunctions.enterData(CurrentCompany,data);
    }

    public void fillMobileNum(String data)
    {
        browserFunctions.enterData(MobileNumber,data);
    }
    public void fillDateOfBirth(String data)
    {
        browserFunctions.enterData(DateOfBirth,data);
    }
    public void fillPositionApplying(String data)
    {
        browserFunctions.enterData(PositionApplying,data);
    }
    public void fillPortFolioWebsite(String data)
    {
        browserFunctions.enterData(PortFolioWebsite,data);
    }
    public void fillSalaryRequirements(String data)
    {
        browserFunctions.enterData(SalaryRequirements,data);
    }
    public void fillWhentoStart(String data)
    {
        browserFunctions.enterData(WhentoStart,data);
    }
    public void fillAddress(String data)
    {
        browserFunctions.enterData(Address,data);
    }
    public void fillResume(String data)
    {
        WebElement uploadElement = Base.driver.findElement(resume);
        uploadElement.sendKeys(data);
    }
    public void fillrelocate()
    {
        browserFunctions.click(relocate);
    }
    public Boolean verifyAllFields()
    {
        List<WebElement> list=Base.driver.findElements(By.xpath("//div//input"));
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).isDisplayed())
            {
                return false;
            }
        }
        return true;
    }
}
