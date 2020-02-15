package Daraz.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
    public WebDriver driver;
    WebDriverWait wait;
    public CategoryPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,10);
    }

    @FindBy(xpath = "//div[@class='cxzbx5']")
    private WebElement divLeftFilterColumn;

    @FindBy(xpath = "//div[@class='c3trXJ']")
    private WebElement divSorting;

    @FindBy(xpath = "//div[@class='c1_t2i']")
    private WebElement divAllItems;

    @FindBy(xpath = "//ul[contains(@class,'ant-pagination')]")
    private  WebElement divPagination;

    public WebElement getDivLeftFilterColumn()
    {
        return divLeftFilterColumn;
    }
    public WebElement getDivSorting()
    {
        return divSorting;
    }
    public WebElement getDivAllItems()
    {
        return divAllItems;
    }
    public WebElement getDivPagination()
    {
        return divPagination;
    }


}
