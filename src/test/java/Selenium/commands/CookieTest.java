package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookieTest {
    WebDriver driver;

    public CookieTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void cookie(){
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("user123");
        driver.findElement(By.name("password")).sendKeys("password223");
        driver.findElement(By.name("submit")).click();
        Set<Cookie> cookies = driver.manage().getCookies();

        for(Cookie ck:cookies) {
            System.out.println(ck.getName() +" "+ck.getValue());
            driver.manage().deleteCookieNamed("Selenium");
        }
    }
}
