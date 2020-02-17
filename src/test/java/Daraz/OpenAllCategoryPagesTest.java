package Daraz;

import Daraz.Common.Hover;
import Daraz.Common.Waits;
import Daraz.Common.WindowHandles;
import Daraz.pageObjects.CategoryPage;
import Daraz.pageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import resources.base;

import java.io.IOException;
import java.util.List;

public class OpenAllCategoryPagesTest extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage landingPage;
    Hover hover;
    CategoryPage categoryPage;
    WindowHandles windowHandles;
    Waits wait;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        hover = new Hover(driver);
        categoryPage = new CategoryPage(driver);
        windowHandles = new WindowHandles(driver);
        wait = new Waits(driver);
    }

    @BeforeMethod
    public void removeBeFriendsPopUp() {

        try {
            wait.waitUntilTheVisibilityOfElement(landingPage.getBtnBeFriendClose());
            if (landingPage.getBtnBeFriendClose().isDisplayed()) {
                landingPage.getBtnBeFriendClose().click();
            }
        } catch (Exception e) {
            log.info("Friends with Daraz popup element not found");
        }
    }

    @Test
    public void openAllCategoryPagesTest() {
        List<WebElement> allCategories = landingPage.getAllCategories();
        for (int k = 0; k < allCategories.size() - 10; k++) {
            hover.hoverOver(allCategories.get(k));

            List<WebElement> subCategories = landingPage.getSubcategories(k + 1);
            for (int j = 0; j < subCategories.size(); j++) {
                hover.hoverOverAndOpenPageInNewTab(subCategories.get(j));
            }
        }

        windowHandles.openNextWindow();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}