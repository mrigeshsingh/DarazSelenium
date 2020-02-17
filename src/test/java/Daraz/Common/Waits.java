package Daraz.Common;

import Daraz.pageObjects.CategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    public WebDriver driver;
    WebDriverWait wait;
    CategoryPage categoryPage;

    public Waits(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        categoryPage = new CategoryPage(driver);
    }

    public void waitUntilTheVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public  void waitUntiltextPresentInElemet(WebElement element, String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public boolean waitUntilSubCategoryPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(categoryPage.getDivLeftFilterColumn()));
        wait.until(ExpectedConditions.visibilityOf(categoryPage.getDivSorting()));
        wait.until(ExpectedConditions.visibilityOf(categoryPage.getDivAllItems()));
        wait.until(ExpectedConditions.visibilityOf(categoryPage.getDivPagination()));

        return true;
    }

}