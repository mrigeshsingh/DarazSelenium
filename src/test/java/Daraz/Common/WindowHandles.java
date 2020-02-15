package Daraz.Common;

import Daraz.pageObjects.CategoryPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import resources.base;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public WebDriver driver;
    Waits wait;

    public static Logger log = LogManager.getLogger(base.class.getName());
    public  WindowHandles(WebDriver driver)
    {
        this.driver = driver;
        wait = new Waits(driver);
    }
    public void openNextWindow()
    {
        String mainWindow = driver.getWindowHandle();
        // It returns no. of windows opened by WebDriver and will return Set of Strings
        Set<String> set = driver.getWindowHandles();
        // Using Iterator to iterate with in windows
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();
            // Compare whether the main windows is not equal to child window. If not equal, we will close.
            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                log.info(driver.switchTo().window(childWindow).getTitle()+" page loaded");
                Assert.assertTrue(wait.waitUntilSubCategoryPageLoad());
                driver.close();
            }
        }
    }
}
