package Pages;

import Utiliti.Driver;
import Utiliti.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;


    @FindBy(className = "custom-checkbox__icon")
    public WebElement rememberCheckBox;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgetPasswordLink;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LoginButton;

    @FindBy(className = "bitnami-corner-image")
    public WebElement manageImage;

    public String validateLoginPageTitle() {
        return Driver.getDriver().getTitle();
    }


    public boolean validateManageImage() {
        return manageImage.isDisplayed();
    }

    public void Login(String un,String pass){
        username.sendKeys(un);
        password.sendKeys(pass);
        LoginButton.click();
    }

    public String checkForgetLink(){
        forgetPasswordLink.click();
        return Driver.getDriver().getTitle();
    }

    public boolean rememberCheck() throws InterruptedException {
        Actions ac = new Actions(Driver.getDriver());
        ac.moveToElement(rememberCheckBox).build().perform();
        rememberCheckBox.click();
        Thread.sleep(3000);
        return rememberCheckBox.isEnabled();
    }



}