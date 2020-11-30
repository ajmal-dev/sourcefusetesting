package main.java.uiAutomation.testcases;

import main.java.uiAutomation.core.Base;
import main.java.uiAutomation.core.BrowserFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login
{
    BrowserFunctions browserFunctions=new BrowserFunctions();
    @Test(testName = "Login to source Fuse")
    public void login() throws InterruptedException {
        Base.driver.get(" http://sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
        Thread.sleep(5000);
        Base.driver.switchTo().alert();

        Base.driver.findElement(By.id("userID")).sendKeys("sfwebhtml");
        Base.driver.findElement(By.id("password")).sendKeys("t63KUfxL5vUyFLG4eqZNUcuRQ");
        Base.driver.switchTo().alert().accept();
        Base.driver.switchTo().defaultContent();
    }
}
