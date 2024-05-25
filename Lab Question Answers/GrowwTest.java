package Test_Groww;

import java.io.IOException;
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
import utils.Reporter;
import utils.Screenshot;

public class Test_groww{
	public static WebDriver driver;
	public Reporter rr;
	public Screenshot ss;
	
 @BeforeMethod
    public WebDriver beforeMethod() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
		driver.get("https://groww.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverListener listener = new EventHandler();
		driver = new EventFiringDecorator<>(listener).decorate(driver);
		return driver;
        
    }
	@Test
	public void testcase() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
        WebElement calculator =  driver.findElement(By.linkText("Calculators"));
        calculator.click();
        Thread.sleep(5000);
        String checkCalc = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/h1")).getText();
        System.out.println(checkCalc);

        if(checkCalc.contains("Calculators"))
        {
            System.out.println("cal found");
			ss.getScreenShot(driver, "calc_verify.png");
            
        }
        else{
            System.out.println("Not found");
        }

        WebElement homeLoan = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/a[15]"));
        homeLoan.click();
        Thread.sleep(5000);

       

        String loan ="230000";
        String rateOfInt ="8";
        String ten = "25";

        WebElement loanAmount = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input"));
        loanAmount.clear();
        loanAmount.sendKeys(loan);
        WebElement rate = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div/input"));
        rate.clear();
        rate.sendKeys(rateOfInt);
        WebElement tenure = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/input"));
        tenure.clear();
        tenure.sendKeys(ten);

        Thread.sleep(10000);


        String auto = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p")).getText();
        if(auto.contains("Your Amortization Details (Yearly/Monthly)"))
        {
            ss.getScreenShot(driver, "verify.png");
        }
		rr.generateExtentReport("groww-extent-reports");

        driver.close();
	}

	
}
