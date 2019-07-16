package Utiliti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected SoftAssert softassert;
    protected Actions actions;

@BeforeClass
public void setUpMethod(){

    driver = Driver.getDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    actions = new Actions(driver);
    softassert = new SoftAssert();
}


    @AfterMethod
    public void tearsDown(){
        Driver.closeDriver();
        softassert.assertAll();
    }





}
