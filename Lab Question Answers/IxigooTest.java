package Ixigo_Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.EventHandler;

public class Test_ixigo {
	public static WebDriver driver;
	
 @BeforeMethod
    public WebDriver beforeMethod() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
		driver.get("https://www.ixigo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverListener listener = new EventHandler();
		driver = new EventFiringDecorator<>(listener).decorate(driver);
		return driver;
        
    }

	@Test
    public void testCase() throws Exception
    {
        WebElement roundTrip = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]"));
        roundTrip.click();

        WebElement From = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div"));
        From.click();
        Thread.sleep(2000);

        WebElement fromCity = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[3]/li"));
        fromCity.click();

        Thread.sleep(2000);

        WebElement to = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]"));
        to.click();

        Thread.sleep(2000);

        WebElement toCity = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/li"));
        toCity.click();

        Thread.sleep(2000);

        WebElement dept = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div"));
        dept.click();

        Thread.sleep(2000);

        WebElement deptDate = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[26]"));
        deptDate.click();

        Thread.sleep(2000);

        WebElement ret = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]"));
        ret.click();

        Thread.sleep(2000);

        WebElement retDate = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[28]"));
        retDate.click();

        Thread.sleep(2000);

        WebElement travel = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div/div"));
        travel.click();

        Thread.sleep(2000);

        WebElement travelChild = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[2]"));
        travelChild.click();

        Thread.sleep(2000);

        WebElement travelClass = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]"));
        travelClass.click();

        Thread.sleep(2000);

        WebElement done = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/button"));
        done.click();

        Thread.sleep(5000);

        WebElement searchButton = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/button"));
        searchButton.click();

        Thread.sleep(10000);

        
    }

	
}
