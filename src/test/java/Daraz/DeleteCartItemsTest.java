package Daraz;

import Daraz.Common.Login;
import Daraz.Common.Waits;
import Daraz.pageObjects.CartPage;
import Daraz.pageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
    Waits wait;

    @BeforeClass
    public void initializeBrower() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        login = new Login(driver);
        landingPage = new LandingPage(driver);
        cartPage = new CartPage(driver);
        wait = new Waits(driver);
    }


    @Test (dependsOnGroups = "RunFirstAddToCart")
    public void validateDelteCartItems() {
        login.userLogin();
        landingPage.getCartBtn().click();

        if (cartPage.getTxtEmptyCartSize().size() == 1) {
            log.info("Cart is Empty");
        } else {
            cartPage.getSelectAllItems().click();
            wait.waitUntilTheVisibilityOfElement(cartPage.getDivShippingFee());
            cartPage.getCartItemsDeleteBtn().click();
            wait.waitUntilTheVisibilityOfElement(cartPage.getBtnDeleteConfirmationPopUp());
            cartPage.getCartDeleteOkBtn().click();
        }

        wait.waitUntilTheVisibilityOfElement(cartPage.getEmptyCartTxt());
        Assert.assertTrue(cartPage.getEmptyCartTxt().getText().equalsIgnoreCase("There are no items in this cart"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
