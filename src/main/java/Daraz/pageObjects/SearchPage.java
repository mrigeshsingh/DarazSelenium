package Daraz.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    public WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }


    @FindAll({ @FindBy(xpath = "//div[@class='c1_t2i'] //div[@class='c2prKC']")})
    private List<WebElement> searchedItems;

    @FindBy(xpath = "//span[@class='ant-modal-close-x']")
    private WebElement btnPopUpClose;

    @FindBy(xpath = "//a[contains(text(),'CHECKOUT')]")
    private  WebElement btnCheckOut;

    @FindBy(xpath = "//span[@class='ant-alert-message']")
    private WebElement txtError;

    public  WebElement getErrorTxt()
    {
        return txtError;
    }

    public void waitUntilAddToCartBtnIsVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilCartPopUpIsDisplayed()
    {
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(getCheckOutBtn()),ExpectedConditions.visibilityOf(getErrorTxt())));
    }




    public List<WebElement> getSearchItems() {
        return searchedItems;
    }

    public WebElement getAddToCartBtn(int index)
    {
        index = index + 1;
        String addBtn = "//div[@class='c1_t2i'] //div[@class='c2prKC']["+index+"] //div[@class='c31VUX']/button";
        WebElement btnAddToCart = driver.findElement(By.xpath(addBtn));
        return btnAddToCart;
    }


    public WebElement getPopUpClose()
    {
        return btnPopUpClose;
    }

    public WebElement getCheckOutBtn()
    {
        return btnCheckOut;
    }
}
