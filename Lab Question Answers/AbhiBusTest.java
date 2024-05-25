package Test_Abhibus;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Base;
import utils.EventHandler;
import utils.Reporter;
import utils.Screenshot;

public class Test_abhibus  extends Base{
	public static WebDriver driver;
	private String url = "https://www.abhibus.com/";

	Screenshot ss;

	Reporter rr;
	
 @BeforeMethod
    public WebDriver beforeMethod() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
		driver.get("https://www.abhibus.com/");
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
		WebDriverListener listener = new EventHandler();
		driver = new EventFiringDecorator<>(listener).decorate(driver);
		return driver;
        
    }
	@Test
     public void testCase1() throws Exception
     {
		
        Thread.sleep(5000);

        WebElement train = driver.findElement(By.xpath("/html/body/header/div/div[2]/div/nav/a[2]"));
        train.click();
        
        Thread.sleep(3000);

        if(driver.getCurrentUrl().contains("trains"))
        {
            System.out.println("Name Verified");
			ss.getScreenShot(driver, "Name.png");
        }

        WebElement logo = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/a"));
        logo.click();

        Thread.sleep(3000);

        WebElement login = driver.findElement(By.xpath("/html/body/header/div/div[3]/div/nav/a[3]"));
        login.click();


        if(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/h4")).getText().contains("Login to AbhiBus"))
        {
            System.out.println("login verified");
			ss.getScreenShot(driver, "Login.png");
        }
     

		driver.navigate().to(url);
        Thread.sleep(5000);

        WebElement from = driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/div[2]/input"));
        from.sendKeys("Mumbai" + Keys.RETURN);
        
        WebElement to = driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/div[2]/input"));
        to.sendKeys("Pune" + Keys.RETURN);

        WebElement search = driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/div[2]/div/div[5]/button"));
        search.click();

        Thread.sleep(2000);

        String urlVerify = driver.getCurrentUrl();

        if(urlVerify.contains("Mumbai") && urlVerify.contains("Pune"))
        {
            System.out.println("Cities verified");
			ss.getScreenShot(driver, "urlVerify.png");
        }

     
		driver.navigate().to(url);
        Thread.sleep(5000);

        WebElement links =  driver.findElement(By.xpath("/html/body/footer/div/div[2]/div/div/div[1]/div/div/div/div/button[5]"));
        links.click();

        WebElement news  = driver.findElement(By.xpath("/html/body/footer/div/div[2]/div/div/div[2]/div/div/div/div[7]/a"));
        news.click();

        Thread.sleep(3000);

        if(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/h2")).getText().contains("Media"))
        {
            System.out.println("Head verified");
			ss.getScreenShot(driver, "head.png");
        }
		rr.generateExtentReport("extent-report");
     }

	
	}
