package Daraz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'icon-delete')]")
    private WebElement btnDeleteAllCartItems;


    @FindBy(xpath = "//div[@class='list-header-left'] //input[@type='checkbox']")
    private WebElement checkBoxSelectAll;

    @FindAll({@FindBy(xpath = "//div[@class='cart-empty-text']")})
    private List<WebElement> txtEmptyCartSize;

    @FindBy(xpath = "//button[@class='ok']")
    private WebElement BtnDeleteCartOk;

    @FindBy(xpath = "//div[@class='cart-empty-text']")
    private WebElement txtEmptyCart;

    @FindAll({ @FindBy(xpath = "//div[@class='cart-item-inner']")})
    private List<WebElement> countCartItems;

    public WebElement getCartItemsDeleteBtn() {
        return btnDeleteAllCartItems;
    }

    public List<WebElement> getTxtEmptyCartSize() {
        return txtEmptyCartSize;
    }

    public WebElement getSelectAllItems() {
        return checkBoxSelectAll;
    }

    public WebElement getCartDeleteOkBtn() {
        return BtnDeleteCartOk;
    }

    public WebElement getEmptyCartTxt() {
        return txtEmptyCart;
    }

    public int getCartItemsCount()
    {
        return countCartItems.size();
    }
}
