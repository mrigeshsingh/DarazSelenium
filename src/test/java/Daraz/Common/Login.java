package Daraz.Common;

import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import resources.base;

import java.io.IOException;

public class Login extends base {

    LandingPage landingPage;
    LoginPage loginPage;
    public WebDriver driver;
    Wait wait;

    public Login(WebDriver driver) throws IOException {
        this.driver = driver;
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        wait = new Wait(driver);
    }

    public void userLogin() {
        landingPage.getLoginBtn().click();
        loginPage.getUsername().sendKeys("9841558034");
        loginPage.getPassword().sendKeys("maestro@222");
        loginPage.getLogin().click();
        wait.waitUntilTheVisibilityOfElement(landingPage.getBtnAfterLogin());
        Assert.assertTrue(landingPage.getBtnAfterLogin().getText().contains("ACCOUNT"));
    }
}
