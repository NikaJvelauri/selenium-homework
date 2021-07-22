package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CommandsTest {
    public static void main(String[] args) {
        System.out.println("HomewWork For TBC IT ACademy");
    }
    @Test
    public void enableButton() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.cssSelector("input[type=checkbox]"));
        element.click();
    }
    @Test
    public void inputField() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        WebElement element1= driver.findElement(By.cssSelector("#input-example > input[type=text]"));
        element.click();
        Thread.sleep(3000);
        element1.sendKeys("Bootcamp");
        element1.clear();

    }

}
