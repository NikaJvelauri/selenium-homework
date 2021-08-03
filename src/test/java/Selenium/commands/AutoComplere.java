package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AutoComplere {
    WebDriver driver;

    public AutoComplere() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void autoComplete() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement element=  driver.findElement(By.name("q"));
        element.sendKeys("Automation");
//        List<WebElement> result = driver.findElements(By.xpath("//ul/li[@class='sbct']"));



        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        List<WebElement> elements = driver.findElements(By.xpath("//ul/li[@class='sbct']"));

        elements.forEach(e -> {
            js.executeScript("arguments[last].click();", e);

        });




    }

}