package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WaitsTest {
    WebDriver driver;

    public WaitsTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void waitTest(){
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"startStopButton\"]"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'resetButton')]")));
        System.out.println("Printed Text: " + driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div")).getText());
        driver.quit();
    }


}
