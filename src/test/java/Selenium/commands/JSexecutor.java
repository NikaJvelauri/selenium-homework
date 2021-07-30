package Selenium.commands;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.Test;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;


public class JSexecutor {
    WebDriver driver;

    public JSexecutor() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void moveToElement() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement magic = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]/span"));

        actions.moveToElement(magic).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]/span"));
        js.executeScript("arguments[0].click();", deleteButton);

    }
    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        WebElement entry = driver.findElement(By.id("zone2-entries"));
        actions.moveToElement(entry).perform();


        //ramodenimejer gavakete chamosqrolva shemdeg ascrolva da shemdeg isev chamosqrolva ro entry-ebi momateboda
        // da thread sleep gavuwere uketesi tvalsachinoebistvis
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,200)");
            js.executeScript("window.scrollBy(0,-200)");
            js.executeScript("window.scrollBy(0,200)");
            Thread.sleep(2000);
        }


        String wholeText =  js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(wholeText);

    }

}
