package Selenium.commands;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.Test;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;


public class WebTablesTest {
    WebDriver driver;

    public WebTablesTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void webTablesTest(){
        driver.get("https://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        System.out.println("Price of Honda: " + driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[4]/td[3]")).getText() + "INR");
    }
}