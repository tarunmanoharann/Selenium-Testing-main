package PuriesHotel_Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import utils.EventHandler;
import utils.LoggerHandler;




public class Test_purihotel {
    public static WebDriver driver;
    LoggerHandler logger;

    @BeforeTest
    public WebDriver beforeMethod() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
        driver.get("https://www.puriholidayresort.com/");
         WebDriverListener listener = new EventHandler();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        return driver;
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        

    }
    
    @Test(priority = 0)
    public void test1() throws Exception {

                
        Thread.sleep(10000);
        logger.logInfo("Starting test1");
        Thread.sleep(3000);
        logger.logInfo("Clicking on the button");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(10000);

        logger.logInfo("Opening date picker");
        driver.findElement(By.xpath("//input[@id='arr_datepicker']")).click();
        Thread.sleep(3000);
        logger.logInfo("Selecting date 30");
        driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text(),'30')]")).click();

        Thread.sleep(3000);
        logger.logInfo("Clicking on custom button");
        driver.findElement(By.xpath("//button[@class='custom-btn']")).click();
        logger.logInfo("test1 completed");
    }

    @Test(priority = 1)
    public void test2() throws Exception {
        driver.navigate().to("https://www.puriholidayresort.com/");
        logger.logInfo("Starting test2");
        Thread.sleep(3000);
        logger.logInfo("Clicking on the button");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(3000);
        logger.logInfo("Moving to 'Rooms & Suites' menu");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[2]/a[contains(text(),'Rooms & Suites')]"))).build()
                .perform();
        Thread.sleep(3000);
        logger.logInfo("Clicking on 'Royal Suite'");
        driver.findElement(By.xpath("//a[contains(text(),'Royal Suite')]")).click();

        Thread.sleep(3000);
        logger.logInfo("Clicking on 'AMENITIES'");
        driver.findElement(By.xpath("//h3[contains(text(),'AMENITIES')]")).click();
        logger.logInfo("test2 completed");
    }

    @Test(priority = 2)
    public void test3() throws Exception {
        driver.navigate().to("https://www.puriholidayresort.com/");
        logger.logInfo("Starting test3");
        Thread.sleep(3000);
        By continLocator = By.xpath(
                "//textarea[contains(text(),'Title your review - Describe your stay in one sentence or less. ')]");
        Thread.sleep(3000);
        logger.logInfo("Clicking on the button");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(3000);
        logger.logInfo("Moving to 'About Puri' menu");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[1]/a[contains(text(),'About Puri')]"))).build()
                .perform();

        Thread.sleep(3000);
        logger.logInfo("Clicking on 'Chilika Lake'");
        driver.findElement(By.xpath("//a[contains(text(),'Chilika Lake')]")).click();

        Thread.sleep(4000);
        logger.logInfo("Entering review text");
        driver.findElement(continLocator).click();
        driver.findElement(continLocator).sendKeys("Excellent");

        Thread.sleep(3000);
        logger.logInfo("Clicking on 'Continue'");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                logger.logInfo("Switching to new window");
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(3000);
        logger.logInfo("Selecting 'Family'");
        driver.findElement(By.xpath("//span[contains(text(),'Family')]")).click();
        logger.logInfo("test3 completed");
    }

}
