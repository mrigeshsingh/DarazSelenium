package Daraz;

import Daraz.Common.Hover;
import Daraz.Common.Login;
import Daraz.Common.Waits;
import Daraz.pageObjects.CartPage;
import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;


public class AddToCartTest extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage landingPage;
    SearchPage searchPage;
    Login login;
    CartPage cartPage;
    Hover hover;
    Waits wait;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        searchPage = new SearchPage(driver);
        login = new Login(driver);
        cartPage = new CartPage(driver);
        hover = new Hover(driver);
        wait = new Waits(driver);
    }

    @Test
    public void addToCart() throws InterruptedException {
        login.userLogin();

        landingPage.getSearchBar().sendKeys(prop.getProperty("searchItem"));
        landingPage.getSearchBar().sendKeys(Keys.ENTER);

        int count = 0;
        for (int k = 0; k < searchPage.getSearchItems().size(); k++) {
            WebElement parent = searchPage.getSearchItems().get(k);
            WebElement addToCartBtn = searchPage.getAddToCartBtn(k);

            hover.hoverOver(parent);
            wait.waitUntilTheVisibilityOfElement(addToCartBtn);
            addToCartBtn.click();

            searchPage.waitUntilCartPopUpIsDisplayed();
            searchPage.getPopUpClose().click();
            count++;

            //Add at most three items from the search result
            if (count == 3)
                break;
        }

        wait.waitUntilTheInvisibilityOfElement(searchPage.getDivAddToCartPopUp());
        landingPage.getCartBtn().click();
        Assert.assertTrue(cartPage.getCartItemsCount() > 0);
    }

    @AfterClass
    public void teardown() {
        driver.close();
        driver = null;
    }
}