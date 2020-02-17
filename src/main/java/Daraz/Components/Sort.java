package Daraz.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sort {
    public WebDriver driver;

    public Sort(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='c3trXJ'] //div[@class='ant-select-selection__rendered']")
    private WebElement btnSort;

    @FindBy(xpath = "//div[contains(text(),'Price low to high')]")
    private WebElement btnSortByLowToHight;

    @FindBy(xpath = "//div[contains(text(),'Price high to low')]")
    private WebElement btnSortByHightToLow;

    @FindBy(xpath = "//ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-vertical  ant-select-dropdown-menu-root'] //div[contains(text(),'Popularity')]")
    private WebElement btnPopularity;

    public  WebElement getBtnSort()
    {
        return btnSort;
    }
    public void lowToHigh()
    {
        btnSort.click();
        btnSortByLowToHight.click();
    }
    public void highToLow()
    {
        btnSort.click();
        btnSortByHightToLow.click();
    }
    public void popularity()
    {
        btnSort.click();
        btnPopularity.click();
    }


}
