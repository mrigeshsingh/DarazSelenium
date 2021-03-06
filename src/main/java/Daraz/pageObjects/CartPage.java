package Daraz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {

    public WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//span[contains(@class,'icon-delete')]")
    private WebElement btnDeleteAllCartItems;


    @FindBy(xpath = "//div[@class='list-header-main'] //input[@type='checkbox']")
    private WebElement checkBoxSelectAll;

    @FindAll({@FindBy(xpath = "//div[@class='cart-empty-text']")})
    private List<WebElement> txtEmptyCartSize;

    @FindBy(xpath = "//button[@class='ok']")
    private WebElement BtnDeleteCartOk;

    @FindBy(xpath = "//div[@class='cart-empty-text']")
    private WebElement txtEmptyCart;

    @FindBy(xpath = "//div[contains(text(),'Shipping Fee')]")
    private WebElement divShippingFee;

    @FindAll({@FindBy(xpath = "//div[@class='cart-item-inner']")})
    private List<WebElement> countCartItems;

    @FindBy(xpath = "//button[@class='ok']")
    private WebElement btnDeleteConfirmationPopUp;

    @FindBy(xpath = "//span[@id='topActionCartNumber']")
    private WebElement txtCartCount;

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

    public WebElement getDivShippingFee() {
        return divShippingFee;
    }

    public int getCartItemsCount() {
        return countCartItems.size();
    }

    public WebElement getBtnDeleteConfirmationPopUp() {
        return btnDeleteConfirmationPopUp;
    }

    public WebElement getCartBtnCount()
    {
        return txtCartCount;
    }


}
