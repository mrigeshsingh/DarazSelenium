package Daraz.Common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Hover {
    private Actions actions;
    WebDriver driver;

    public Hover(WebDriver driver)
    {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void hoverOver(WebElement element)
    {
        actions.moveToElement(element).build().perform();
    }

    public void hoverOverAndOpenPageInNewTab(WebElement element)
    {
        actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
    }
}
