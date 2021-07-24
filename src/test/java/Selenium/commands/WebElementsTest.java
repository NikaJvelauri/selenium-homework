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
    public void addAndPrint(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        for (int i = 0; i < 3; i++) {
            element.click();
        }
        System.out.println("Printed Text: "+ driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button[3]")).getText());
        System.out.println("Printed Text: "+ driver.findElements(By.cssSelector("input[class^='added']")));
        System.out.println("Printed Text: "+ driver.findElement(By.xpath("//button[contains(@class, 'manually') and text() = 'Delete']")).getText());
    }
    @Test
    public void challengingDom(){
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();
//        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[1]"));
        System.out.println("Lorem Value: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2-1]")).getText());
        System.out.println("Lorem Value: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2+1]")).getText());
        /*td[2+1] da /td[2-1] cota sacacilod chans 1 ro davamate da davakeli,
         mara davalebashi ewera ro konkretul [2] adgilze mdgomi sityvis wina da shemdegi unda dagveprinta da yvelaze martivi es movifiqre :
         (edit  after 5 minutes of thinking) tan vfiqrob parent-child funqcia xo ar mchirdeba da araferi mafqirdeba :d * ro gadavce an ragac egeti :D */

    }
}
