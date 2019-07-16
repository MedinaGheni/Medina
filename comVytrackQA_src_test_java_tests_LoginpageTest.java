package tests;

import Pages.LoginPage;
import Utiliti.Config;
import Utiliti.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginpageTest  {


    LoginPage olg = new LoginPage();

    @BeforeMethod
        public void setUp() {
    Driver.getDriver().get(Config.getProperty("url"));

}
    @Test(priority = 1)
    public void LoginpageTitle(){
       Assert.assertEquals(olg.validateLoginPageTitle(),"Login");
    }

    @Test(priority = 2)
    public void VerifyLoginpage(){
    olg.Login(Config.getProperty("truckusername"),Config.getProperty("userpassword"));
    String  titlelogin = Driver.getDriver().getTitle();
        Assert.assertEquals(titlelogin,"Dashboard");
        Driver.getDriver().navigate().forward();
}


    @Test(priority = 3)
    public void manageImageCheck(){
    Assert.assertTrue(olg.validateManageImage());

  }
    @Test
    public void checkForgetlink(){
        String forgetTitil = olg.checkForgetLink();
        Assert.assertEquals(forgetTitil,"Forgot Password");

    }


    @Test
    public void rememberBox() throws InterruptedException {
       Assert.assertTrue(olg.rememberCheck());
    }


    @AfterMethod
    public void tearnDown(){
        Driver.closeDriver();
    }









}
