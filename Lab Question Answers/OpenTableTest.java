package Opentable_Test;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.EventHandler;
import utils.LoggerHandler;


public class OpenTableTest {
	public static WebDriver driver;
    private WebDriverWait wait;
	public final int IMPLICIT_WAIT_TIME=10;
	public final int PAGE_LOAD_TIME=5;
	LoggerHandler logger;
    

 @BeforeMethod
    public WebDriver beforeMethod() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
		driver.get("https://www.opentable.com");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
		WebDriverListener listener = new EventHandler();
		driver = new EventFiringDecorator<>(listener).decorate(driver);
		return driver;
        
    }

	@Test
	public void testcase() throws Exception
	{
		logger.logInfo("Test case started");

		// WebElement location = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[1]/div"));
		// location.click();
		// logger.logDebug("Location menu clicked");
	
		// WebElement Ilocation = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[1]/div/nav/div/div[1]/div[1]/ul/li[6]/a"));
		// Ilocation.click();
	
		// WebElement Mlocation = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[1]/div/nav/div/div[1]/div[2]/ul/li[1]/a"));
		// Mlocation.click();
	
		WebElement city = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/header/div/span/div/div/div[2]/div[1]/div/input"));
		city.sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/main/header/div/span/div/div/div[2]/div[2]/button")).click();
		logger.logInfo("City entered: Bangalore");
		Thread.sleep(4000);

		WebElement clickCui = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/section/div[6]/div/label[4]"));
		clickCui.click();
		Thread.sleep(2000);

		WebElement hotel = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div[2]/div[1]/div[1]/a"));
		hotel.click();
		logger.logInfo("Hotel clicked");
		Thread.sleep(2000);

		for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("user.dir/verify.png"));


		WebElement drop = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[2]/div/article/div/div[1]/div/select"));
		drop.click();

		WebElement dropSize = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[2]/div/article/div/div[1]/div/select/option[4]"));
		dropSize.click();

		WebElement time = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[2]/div/article/div/div[3]/div[2]/div/select"));
		time.click();
		

		WebElement signIn = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[2]/div[1]/button"));
		signIn.click();
		Thread.sleep(2000);





	}
}
