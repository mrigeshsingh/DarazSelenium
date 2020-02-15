package Daraz;

import Daraz.Common.Login;
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
    Login login;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        login = new Login(driver);
        wait = new Waits(driver);
    }

    @Test
    public void validateLogin() {
        login.userLogin();
        Assert.assertTrue(landingPage.getBtnAfterLogin().getText().contains("ACCOUNT"));
    }

    @AfterClass
    public  void tearDown()
    {
        driver.quit();
        driver=null;
    }


}
