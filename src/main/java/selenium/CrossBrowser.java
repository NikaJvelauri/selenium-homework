package selenium;

import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        //Check if parameter passed as 'chrome'
        if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            //  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            WebDriverManager.edgedriver().proxy("192.168.100.50:3128");
            //create chrome instance
            ChromeDriver driver = new ChromeDriver();
            //driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge.exe
            // System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\MicrosoftWebDriver.exe");
            WebDriverManager.edgedriver().setup();
            WebDriverManager.edgedriver().proxy("192.168.100.50:3128");
            //create Edge instance
            EdgeDriver driver = new EdgeDriver();
            //driver = new HtmlUnitDriver(BrowserVersion.EDGE);
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
