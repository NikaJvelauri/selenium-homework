package selenium;

import org.junit.Test;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import javax.annotation.ParametersAreNonnullByDefault;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrossBrowserTest {
    WebDriver driver = null;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        System.out.println("Browser: " + browser);
        if (browser.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();


        } else if (browser.equalsIgnoreCase("Edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        WebElement entry = driver.findElement(By.id("zone2-entries"));
        actions.moveToElement(entry).perform();


        //ramodenimejer gavakete chamosqrolva shemdeg ascrolva da shemdeg isev chamosqrolva ro entry-ebi momateboda
        // da thread sleep gavuwere uketesi tvalsachinoebistvis
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,200)");
            js.executeScript("window.scrollBy(0,-200)");
            js.executeScript("window.scrollBy(0,200)");
            Thread.sleep(2000);
        }


        String wholeText =  js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(wholeText);

    }


    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement fUpload = driver.findElement(By.xpath("//*[@id='file-upload']"));

        fUpload.sendKeys("D:\\Ekko's photo\\Ekko_OriginalSkin.jpg");

        WebElement fSubmit = driver.findElement(By.xpath("//*[@id='file-submit']"));
        fSubmit.click();
        Thread.sleep(2000);

        //mocemuli shemdegi ori xazit gadadis google.comze shemdeg rom vegar poulob fUpload elements,
        //romelic me shevqmeni agdebs StaleElementReferenceException
        //thread.sleep gamoviyene imistvis rom gamochndes rom faili aitvirta da shemdeg gadavides googleshi da gamoitans exceptioni (ps dzaan momwons thread sleep :DD)
        try {
            driver.get("https://www.google.com/");
            fUpload.sendKeys("D:\\Ekko's photo\\Ekko_OriginalSkin.jpg");
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException invoked and handled");
        }

    }






    @AfterTest
    public void tearDown(){
        driver.close();
        System.out.println("Test completed");
    }
}
