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


}
