package Daraz.Common;

import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.base;

import java.io.IOException;

public class Login extends base {

    LandingPage landingPage;
    LoginPage loginPage;
    WebDriverWait wait;
    public WebDriver driver;

    public Login(WebDriver driver) throws IOException {
        this.driver = driver;
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver,10);
    }

    public void userLogin() {
        landingPage.getLoginBtn().click();
        loginPage.getUsername().sendKeys("9841558034");
        loginPage.getPassword().sendKeys("maestro@222");
        loginPage.getLogin().click();
        wait.until(ExpectedConditions.visibilityOf(landingPage.getBtnAfterLogin()));
        Assert.assertTrue(landingPage.getBtnAfterLogin().getText().contains("ACCOUNT"));
    }
}
