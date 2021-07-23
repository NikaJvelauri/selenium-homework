package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsTest {
    WebDriver driver;

    public WebElementsTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void getTextAndClear() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        for (int i = 0; i < 3; i++) {
            element.click();
        }
        System.out.println("Printed Text: "+ driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button[3]")).getText());
    }
}
