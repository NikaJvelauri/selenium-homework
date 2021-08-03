package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FileUploadTest {
    WebDriver driver;

    public FileUploadTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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

}