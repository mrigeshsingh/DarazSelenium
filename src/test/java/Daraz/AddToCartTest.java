package Daraz;

import java.io.IOException;

import Daraz.Common.Login;
import Daraz.pageObjects.CartPage;
import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;

import resources.base;



public class AddToCartTest extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage landingPage;
    SearchPage searchPage;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor executor;
    Login login;
    CartPage cartPage;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage=new LandingPage(driver);
        searchPage=new SearchPage(driver);
        actions=new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        login = new Login(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void addToCart() throws InterruptedException {
        login.userLogin();

        landingPage.getSearchBar().sendKeys("cup");
        landingPage.getSearchBar().sendKeys(Keys.ENTER);

        int count = 0;
        for(int k=0;k<searchPage.getSearchItems().size();k++)
        {
            WebElement parent = searchPage.getSearchItems().get(k);
            WebElement addToCartBtn = searchPage.getAddToCartBtn(k);

            actions.moveToElement(parent).build().perform();
            searchPage.waitUntilAddToCartBtnIsVisible(addToCartBtn);
            addToCartBtn.click();

            searchPage.waitUntilCartPopUpIsDisplayed();
            searchPage.getPopUpClose().click();

            count++;

            if (count==3)
                break;
        }

        Thread.sleep(2000);
        //searchPage.waitUntilCartPopUpIsClosed();

        landingPage.getCartBtn().click();
        Assert.assertTrue(cartPage.getCartItemsCount()>0);
    }

    @AfterClass
    public void teardown() {
        driver.close();
        driver = null;
    }
}