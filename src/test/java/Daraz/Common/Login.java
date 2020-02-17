package Daraz.Common;

import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import resources.base;


public class Login extends base {

    LandingPage landingPage;
    LoginPage loginPage;
    public WebDriver driver;
    Waits wait;

    public Login(WebDriver driver) {
        this.driver = driver;
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        wait = new Waits(driver);
    }

    public void userLogin() {
        landingPage.getLoginBtn().click();
        loginPage.getUsername().sendKeys("9841558034");
        loginPage.getPassword().sendKeys("maestro@222");
        loginPage.getLogin().click();
        wait.waitUntiltextPresentInElemet(landingPage.getBtnAfterLogin(),"ACCOUNT");
    }
}
