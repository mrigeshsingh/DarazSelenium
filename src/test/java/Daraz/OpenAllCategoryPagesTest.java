package Daraz;

import Daraz.Common.Hover;
import Daraz.Common.WindowHandles;
import Daraz.pageObjects.CategoryPage;
import Daraz.pageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OpenAllCategoryPagesTest extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage landingPage;
    Hover hover;
    CategoryPage categoryPage;
    WindowHandles windowHandles;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        hover = new Hover(driver);
        categoryPage = new CategoryPage(driver);
        windowHandles = new WindowHandles(driver);
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

//        String mainWindow = driver.getWindowHandle();
//        // It returns no. of windows opened by WebDriver and will return Set of Strings
//        Set<String> set = driver.getWindowHandles();
//        // Using Iterator to iterate with in windows
//        Iterator<String> itr = set.iterator();
//        while (itr.hasNext()) {
//            String childWindow = itr.next();
//            // Compare whether the main windows is not equal to child window. If not equal, we will close.
//            if (!mainWindow.equals(childWindow)) {
//                driver.switchTo().window(childWindow);
//                log.info(driver.switchTo().window(childWindow).getTitle()+" page loaded");
//                Assert.assertTrue(categoryPage.waitUntilPageLoad());
//            }
//        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}