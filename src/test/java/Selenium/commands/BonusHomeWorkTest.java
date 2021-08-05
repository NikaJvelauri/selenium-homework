package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class BonusHomeWorkTest {
    WebDriver driver;


    public BonusHomeWorkTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void bonusWork() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
        login.sendKeys("555555555");

        WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
        password.sendKeys("password");

        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button"));
        submit.click();
        Thread.sleep(3000);

        String error = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).getText();
        System.out.println(error);

        String expected_error="Please enter valid Email ID/Mobile number";

        //way N1
//        Assert.assertEquals(error,expected_error);

        //way N2
//        Assert.assertTrue(error.contains("Please enter valid Email ID/Mobile number"));

        //way N3
        if(error.equals(expected_error)){
            System.out.println("Error verified");
        }else {
            System.out.println("Error hasn't verified");
        }

    }

}
