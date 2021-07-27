package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToTest {
    WebDriver driver;

    public SwitchToTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void switchTo(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        element.click();
        for(int i = 0; i < 30; i++){
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys("Here Goes");

        driver.switchTo().defaultContent();
        WebElement center = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[2]/span"));
        center.click();


    }

    @Test
    public void alert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
        element.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        Thread.sleep(2000);
        alert.accept();

    }


}
