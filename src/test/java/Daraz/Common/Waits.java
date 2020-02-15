package Daraz.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    public WebDriver driver;
    WebDriverWait wait;

    public  Waits(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public  void waitUntilTheVisibilityOfElement(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilTheInvisibilityOfElement(WebElement element)
    {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}