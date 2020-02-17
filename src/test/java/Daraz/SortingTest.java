package Daraz;

import Daraz.Common.Waits;
import Daraz.Components.Sort;
import Daraz.pageObjects.LandingPage;
import Daraz.pageObjects.SearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.List;

public class SortingTest extends base {
    Sort sort;
    LandingPage landingPage;
    SearchPage searchPage;
    Waits wait;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        sort = new Sort(driver);
        landingPage = new LandingPage(driver);
        searchPage = new SearchPage(driver);
        wait = new Waits(driver);
    }

    @Test
    public void priceLowToHighSortTest() throws InterruptedException {
        landingPage.getSearchBar().sendKeys(prop.getProperty("searchItem"));
        landingPage.getSearchBar().sendKeys(Keys.ENTER);
        sort.lowToHigh();

        wait.waitUntiltextPresentInElemet(sort.getBtnSort(),"Price low to high");

        List<WebElement> priceList = searchPage.getPriceList();
        for (int k = 0; k < priceList.size() - 1; k++) {
            String stringPrice1 = priceList.get(k).getText();
            String stringPrice2 = priceList.get(k + 1).getText();
            int intPriceValue1 = Integer.parseInt(stringPrice1.replaceAll("[^0-9]", ""));
            int intPriceValue2 = Integer.parseInt(stringPrice2.replaceAll("[^0-9]", ""));
            if (intPriceValue1 > intPriceValue2) {
                Assert.assertTrue(false);
                break;
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    public void priceHighToLowTest(){
        landingPage.getSearchBar().sendKeys(prop.getProperty("searchItem"));
        landingPage.getSearchBar().sendKeys(Keys.ENTER);
        sort.highToLow();

        wait.waitUntiltextPresentInElemet(sort.getBtnSort(),"Price high to low");

        List<WebElement> priceList = searchPage.getPriceList();

        for (int k = 0; k < priceList.size() - 1; k++) {
            String stringPrice1 = priceList.get(k).getText();
            String stringPrice2 = priceList.get(k + 1).getText();
            int intPriceValue1 = Integer.parseInt(stringPrice1.replaceAll("[^0-9]", ""));
            //System.out.println(intPriceValue1);
            int intPriceValue2 = Integer.parseInt(stringPrice2.replaceAll("[^0-9]", ""));
            if (intPriceValue1 < intPriceValue2) {
                Assert.assertTrue(false);
                break;
            }
        }
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void naviateToInitialUrl() {
        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
