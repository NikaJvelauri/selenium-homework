package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.util.ArrayList;
import java.util.List;

public class WebFormsTest {
    WebDriver driver;

    public WebFormsTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void webForms(){
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();

        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]")));
        select.selectByVisibleText("Python");
        System.out.println(select.getFirstSelectedOption().getText());

        Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-2\"]")));
        select2.selectByVisibleText("TestNG");
        System.out.println(select2.getFirstSelectedOption().getText());

        Select select3 = new Select(driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-3\"]")));
        select3.selectByVisibleText("JavaScript");
        System.out.println(select3.getFirstSelectedOption().getText());



        WebElement element = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[1]/input"));
        element.click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input"));
        element2.click();
        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[4]/input"));
        element4.click();



        WebElement radio = driver.findElement(By.xpath("//input[@value='yellow']"));
        radio.click();



        WebElement orange = driver.findElement(By.xpath("//*[@id=\"fruit-selects\"]/option[2]"));
        if(orange.isEnabled()){
            orange.click();
        }else{
            System.out.println("Orange option is disabled");
        }



    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
