package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class ActionClassTest{
        WebDriver driver;


        public ActionClassTest(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }

        @Test
        public void actionClass(){
            driver.get("https://demoqa.com/slider");
            driver.manage().window().maximize();

            WebElement slider = driver.findElement(By.xpath("//*[@id='sliderContainer']/div[1]/span/input"));

            Actions actions = new Actions(driver);

//            actions.dragAndDropBy(slider,0,0).release().build().perform();


            actions.clickAndHold(slider);
            for (int i = 1; i <= 25 ; i++) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            }
            actions.release();

            System.out.println(slider.getAttribute("value"));

        }


}