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
    public void fileUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement fUpload = driver.findElement(By.xpath("//*[@id='file-upload']"));

        fUpload.sendKeys("D:\\Ekko's photo\\Ekko_OriginalSkin.jpg");

        WebElement fSubmit = driver.findElement(By.xpath("//*[@id='file-submit']"));
        fSubmit.click();

    }
    
}
