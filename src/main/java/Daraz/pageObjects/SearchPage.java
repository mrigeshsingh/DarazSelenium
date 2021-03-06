package Daraz.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        wait = new WebDriverWait(driver, 60);
    }


    @FindAll({@FindBy(xpath = "//div[@class='c1_t2i'] //div[@class='c2prKC']")})
    private List<WebElement> searchedItems;

    @FindBy(xpath = "//span[@class='ant-modal-close-x']")
    private WebElement btnPopUpClose;

    @FindBy(xpath = "//a[contains(text(),'CHECKOUT')]")
    private WebElement btnCheckOut;

    @FindBy(xpath = "//span[@class='ant-alert-message']")
    private WebElement txtError;

    @FindBy(xpath = "//div[@class='ant-modal-body']")
    private WebElement divAddToCartPopUp;

    @FindAll({@FindBy(xpath = "//span[@class='c13VH6']")})
    private List<WebElement> allPrice;

    public WebElement getErrorTxt() {
        return txtError;
    }

    public List<WebElement> getPriceList() {
        return allPrice;
    }

    public List<WebElement> getSearchItems() {
        return searchedItems;
    }
    public WebElement getDivAddToCartPopUp() {
        return divAddToCartPopUp;
    }

    public WebElement getAddToCartBtn(int index) {
        index = index + 1;
        String addBtn = "//div[@class='c1_t2i'] //div[@class='c2prKC'][" + index + "] //div[@class='c31VUX']/button";
        WebElement btnAddToCart = driver.findElement(By.xpath(addBtn));
        return btnAddToCart;
    }


    public WebElement getPopUpClose() {
        return btnPopUpClose;
    }

    public WebElement getCheckOutBtn() {
        return btnCheckOut;
    }

    public void waitUntilCartPopUpIsDisplayed() {
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(getCheckOutBtn()), ExpectedConditions.visibilityOf(getErrorTxt())));
    }

    public void waitUntilCartPopUpIsInvisible() {
        wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOf(getCheckOutBtn()), ExpectedConditions.invisibilityOf(getErrorTxt())));
    }

}
