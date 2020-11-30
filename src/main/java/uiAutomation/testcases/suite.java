package main.java.uiAutomation.testcases;

import main.java.uiAutomation.core.Base;
import org.apache.commons.mail.EmailException;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class suite

{
    @Parameters({"browser"})
    @BeforeTest(groups = {"functionaltesting"})
    public void beforetest(@Optional String browser) throws IOException, InterruptedException
    {
//        TestCaseLibrary testcaseutility=new TestCaseLibrary();
        Base.setLog4j();
        String date=Base.getDate();
        Base.log.info("The Test Suite is  starting :  "+ date);
        Base.setEnvironment(browser);
        Base.extentConfiguration();
        Base.driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

    }

    @AfterTest(groups = {"functionaltesting"})
    void endTest() throws EmailException, IOException
    {
        Base.extent.flush();// Flushing the report and sending extent report via mail
        Base.driver.quit();
    }
}
