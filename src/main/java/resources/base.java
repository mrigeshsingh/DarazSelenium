package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.javascript.host.event.WebGLContextEvent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if(!(System.getProperty("browser") == null))
        {
            browserName = System.getProperty("browser");
        }

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            //execute in chrome driver

        } else if (browserName.equals("firefox")) {
            //firefox code
        } else if (browserName.equals("IE")) {
            //	IE code
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;

    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void getScreenshot(WebDriver driver,String result) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("target\\screenshots\\" + result + "screenshot.png"));
    }




}
