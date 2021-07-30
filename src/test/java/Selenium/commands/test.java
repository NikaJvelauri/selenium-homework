package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;


public class test {
    WebDriver driver;
    private Object[] Arguments;
    private String Script;

    public test() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        WebElement entry = driver.findElement(By.id("zone2-entries"));
        actions.moveToElement(entry).perform();
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,200)");
            js.executeScript("window.scrollBy(0,-200)");
            js.executeScript("window.scrollBy(0,200)");
            Thread.sleep(2000);
        }




//        for (int i = 0; i < 10; i++){
//            js.executeScript("window.scrollBy(500,500)");
//            js.executeScript("window.scrollBy(0,-400)");
//            js.executeScript("window.scrollBy(0,800)");
//            Thread.sleep(2000);
//        }


    }
}
