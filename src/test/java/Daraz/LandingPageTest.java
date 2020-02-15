package Daraz;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import Daraz.pageObjects.LandingPage;
import resources.base;

public class LandingPageTest extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage landingPage;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
    }

    @Test
    public void validateNavigationBarIsDisplayed() {
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
        log.info("Navigation bar is displayed");
    }

    @Test
    public void validateSearchBarIsDisplayed() {
        Assert.assertTrue(landingPage.getSearchBar().isDisplayed());
        log.info("Search bar is displayed");
    }

    @AfterClass
    public void teardown() {

        driver.close();
        driver = null;

    }

}
