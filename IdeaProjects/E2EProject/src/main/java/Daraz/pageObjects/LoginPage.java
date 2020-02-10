package Daraz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rahulonlinetutor@gmail.com
public class LoginPage {


    public WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder,'Phone Number or Email')]")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[contains(@placeholder,'Please enter your password')]")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public WebElement getUsername() {
        return txtUsername;
    }


    public WebElement getPassword() {
        return txtPassword;
    }

    public WebElement getLogin() {
        return btnLogin;
    }


}
