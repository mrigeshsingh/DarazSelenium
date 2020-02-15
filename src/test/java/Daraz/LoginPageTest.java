package Daraz;

import Daraz.Common.Waits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.LoginPage;
import resources.base;

import java.io.IOException;

public class LoginPageTest extends base{

    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage landingPage;
    LoginPage loginPage;
    Waits wait;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        wait = new Waits(driver);
    }

    @Test
    public void validateLogin() {
        landingPage.getLoginBtn().click();
        loginPage.getUsername().sendKeys(prop.getProperty("username"));
        loginPage.getPassword().sendKeys(prop.getProperty("password"));
        loginPage.getLogin().click();
        wait.waitUntilTheVisibilityOfElement(landingPage.getBtnAfterLogin());

        Assert.assertTrue(landingPage.getBtnAfterLogin().getText().contains("ACCOUNT"));
    }

    @AfterClass
    public  void tearDown()
    {
        driver.quit();
        driver=null;
    }


}
