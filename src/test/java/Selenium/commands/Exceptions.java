package Selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Exceptions {
    WebDriver driver;

    public Exceptions() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void exception(){
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        try{
            WebElement element = driver.findElement(By.xpath("//*[@id='datepicker']"));
            element.click();
        }catch (NoSuchElementException e){
            System.out.println("Exception avoided");
        }


        //am shemtxvevashi ubralod gadavida ivnisis boloricxvi aigo
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//*[@id='datepicker']"));
        element.click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span"));
        element2.click();
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a"));
        element3.click();

//        am shemtxvevashi mindoda gamketebina dinamiurad rogor ketdeba yvela im ricxvs romlis archevas shegvidzlia gawerili aqvs rom data-handler = 'selectDay'
        // amitom vcdilobdi bolo data-handler = 'selectDay' wamomego magram ar gamomivida :D
//        driver.switchTo().frame(0);
//        WebElement elementX = driver.findElement(By.xpath("//*[@id='datepicker']"));
//        elementX.click();
//
//
//        WebElement elementY = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span"));
//        elementY.click();
//
//
//
//        WebElement elementZ = driver.findElement(By.xpath("//*[@data-handler = 'selectDay']"));
//        elementZ.click();


    }




    @Test
    public void invokeAvoid(){
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        try {
            WebElement element = driver.findElement(By.xpath("//*[@id='timerAlertButton']"));
            element.click();
            new WebDriverWait(driver,4).until(ExpectedConditions.alertIsPresent());
        }

        catch(TimeoutException e){
            System.out.println("Exception Avoided");
        }
        catch (NoAlertPresentException e){
            System.out.println("There is no alert");
        }
        try{
            WebElement element2 = driver.findElement(By.xpath("//*[@id=\"promtButton\"]"));
            element2.click();
            driver.switchTo().alert();
            element2.sendKeys("username");
        }catch (StaleElementReferenceException e){
            System.out.println("Exception got caught");
        }catch (UnhandledAlertException e) {
            System.out.println("UnhandledAlertException got caught");
        }
        //veranairad ver vipove is gza tu rogor unda gamomewvia StaleElementReferenceException, magram UnHandledAlertException vipove da magaze gavakete :D



    }


}
