package Daraz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    WebDriverWait wait;


    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void validateLogin() {
        landingPage.getLoginBtn().click();
        loginPage.getUsername().sendKeys("9841558034");
        loginPage.getPassword().sendKeys("maestro@222");
        loginPage.getLogin().click();
        wait.until(ExpectedConditions.visibilityOf(landingPage.getBtnAfterLogin()));
        Assert.assertTrue(landingPage.getBtnAfterLogin().getText().contains("ACCOUNT"));
    }



    @AfterClass
    public  void tearDown()
    {
        driver.quit();
        driver=null;
    }


}
