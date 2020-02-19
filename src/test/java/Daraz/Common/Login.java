package Daraz.Common;

import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import resources.MyDOMXMLParser;
import resources.base;


public class Login extends base {

    LandingPage landingPage;
    LoginPage loginPage;
    public WebDriver driver;
    Waits wait;
    MyDOMXMLParser parser;

    public Login(WebDriver driver) {
        this.driver = driver;
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        wait = new Waits(driver);
        parser = new MyDOMXMLParser();
    }

    public void userLogin() {

        landingPage.getLoginBtn().click();
        String username = parser.getUsernameOrPassword("username");
        String password = parser.getUsernameOrPassword("password");
        loginPage.getUsername().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLogin().click();

        wait.waitUntiltextPresentInElemet(landingPage.getBtnAfterLogin(),"ACCOUNT");

    }
}
