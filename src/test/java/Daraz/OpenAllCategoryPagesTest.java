package Daraz;

import Daraz.Common.Hover;
import Daraz.pageObjects.LandingPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.List;

public class OpenAllCategoryPagesTest extends base {
    LandingPage landingPage;
    Hover hover;

    @BeforeClass
    public void initialize() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        hover = new Hover(driver);
    }

    @Test
    public void openAllCategoryPagesTest()  {
       List<WebElement> allCategories = landingPage.getAllCategories();
       for (int k=0; k<allCategories.size()-9; k++)
       {
           hover.hoverOver(allCategories.get(k));

           List<WebElement> subCategories = landingPage.getSubcategories(k+1);
           for (int j=0;j<subCategories.size();j++)
           {
               hover.hoverOverAndOpenPageInNewTab(subCategories.get(j));
           }
       }
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
        driver = null;
    }
}