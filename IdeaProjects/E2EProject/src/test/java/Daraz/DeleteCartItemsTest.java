package Daraz;

import Daraz.Common.Login;
import Daraz.pageObjects.CartPage;
import Daraz.pageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;

public class DeleteCartItemsTest extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());

    Login login;
    LandingPage landingPage;
    CartPage cartPage;
    WebDriverWait wait;

    @BeforeClass
    public void initializeBrower() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        login = new Login(driver);
        landingPage = new LandingPage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver,10);
    }


    @Test
    public void validateDelteCartItems() throws InterruptedException {
        login.userLogin();
        landingPage.getCartBtn().click();

        if(cartPage.getEmptyCartTxt().size()== 1) {
            log.info("Cart is Empty");
        } else
        {
            cartPage.getSelectAllItems().click();
            Thread.sleep(5000);
            cartPage.getCartItemsDeleteBtn().click();
            Thread.sleep(5000);
            cartPage.getCartDeleteOkBtn().click();
        }

        wait.until(ExpectedConditions.visibilityOf(cartPage.getEmptyCartTxt().get(0)));
        Assert.assertTrue(cartPage.getEmptyCartTxt().get(0).getText().equalsIgnoreCase("There are no items in this cart"));

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
        driver=null;
    }

}
