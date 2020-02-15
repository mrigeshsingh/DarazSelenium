package Daraz.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LandingPage {


    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='lzd-site-menu-root']")
    private WebElement divNavigationBar;

    @FindBy(id = "q")
    private WebElement txtSearchBar;

    @FindBy(xpath = "//div[@id='anonLogin'] //a")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[@id='myAccountTrigger']")
    private WebElement btnAfterLogin;

    @FindBy(xpath = "//span[@class='cart-icon']")
    private WebElement btnCart;

    @FindAll({@FindBy(xpath = "//ul[@class='lzd-site-menu-root']/li")})
    private List<WebElement> btnCategories;

    @FindAll({@FindBy(xpath = "//ul[@class='lzd-site-menu-root']/li")})
    private List<WebElement> btnSubCategories;


    public WebElement getNavigationBar() {
        return divNavigationBar;
    }

    public WebElement getSearchBar() {
        return txtSearchBar;
    }

    public WebElement getLoginBtn() {
        return btnLogin;
    }

    public WebElement getBtnAfterLogin() {
        return btnAfterLogin;
    }

    public WebElement getCartBtn() {
        return btnCart;
    }

    public List<WebElement> getAllCategories()
    {
        return btnCategories;
    }

    public List<WebElement> getSubcategories(int position)
    {
        String subCategory = "//ul[@class='lzd-site-menu-sub Level_1_Category_No"+position+" lzd-site-menu-sub-active']/li";
        System.out.println(subCategory);
        return driver.findElements(By.xpath(subCategory));
    }



}
	
	
	

