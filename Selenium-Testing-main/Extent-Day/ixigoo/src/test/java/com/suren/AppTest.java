package com.suren;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class AppTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setUp() {

       ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test(priority = 1)
    public void roundTripBooking() throws Exception {
        test = extent.createTest("Round Trip Booking");
      
        try {
            driver.get("https://www.ixigo.com/");

            WebElement RoundTrip = driver.findElement(By.cssSelector(
                                        "body > main > div.max-w-\\[1240px\\].m-auto.mainContainer > div.pt-30.mx-0.relative.px-20.xl\\:px-0 > div.border-none.shadow-500.p-20.flex.flex-col.gap-10.rounded-20.bg-white.undefined > div.flex.justify-between.items-center > div.flex.flex-col > div > button.flex.items-center.relative.transition-all.min-h-\\[40px\\].py-5.border.rounded-full.px-15.text-primary.hover\\:bg-primary-over.border-secondary.hover\\:bg-subbrand-50"));
                                RoundTrip.click();
                        
                                Thread.sleep(2000);
                                WebElement From = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div"));
                                From.click();
                                Thread.sleep(2000);
                                WebElement FromCity = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[2]/li"));
                                FromCity.click();
                                Thread.sleep(2000);
                                WebElement To = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div"));
                                To.click();
                                Thread.sleep(2000);
                                WebElement ToCity = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[3]/li"));
                                ToCity.click();
                        
                                Thread.sleep(2000);
                                WebElement Depature = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div"));
                                Depature.click();
                                Thread.sleep(2000);
                                
                                WebElement DepatureDate = driver.findElement(By.xpath(
                                        "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div"));
                                DepatureDate.click();
                                Thread.sleep(2000);
                                WebElement Return = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]"));
                                Return.click();
                                Thread.sleep(2000);
                                WebElement ReturnDate = driver.findElement(By.xpath(
                                        "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[4]"));
                                ReturnDate.click();
                        
                                Thread.sleep(2000);
                                WebElement TravelersClass = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[1]/div"));
                                TravelersClass.click();
                                Thread.sleep(2000);
                                WebElement TravelerAdult = driver.findElement(By.xpath(
                                        "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[2]"));
                                TravelerAdult.click();
                                Thread.sleep(2000);
                                WebElement TravelerChild = driver.findElement(By.xpath(
                                        "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[2]"));
                                TravelerChild.click();
                                Thread.sleep(2000);
                                WebElement Class = driver.findElement(
                                        By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]"));
                                Class.click();
                                Thread.sleep(2000);
                                WebElement Done = driver
                                        .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/button"));
                                Done.click();
                                Thread.sleep(2000);
                                WebElement Search = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/button"));
                                Search.click();
                        
                                Thread.sleep(10000);
                
            WebElement retDate = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div[1]/div[2]/div[1]/div/div/div/div/p[2]"));
            Assert.assertTrue(retDate.getText().contains("Thu, 16 May"));
            test.log(Status.PASS, "Round trip booking completed successfully");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Round trip booking failed");
            takeScreenshot("round_trip_booking_failed");
            throw e;
        }
    }

    @Test(priority = 2)
    public void navigateToAboutUsPage() throws Exception {
        test = extent.createTest("Navigate to About Us Page");
        
        try {
            driver.get("https://www.ixigo.com/");
            WebElement aboutUsLink = driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div/div[2]/div[1]/p[1]/a"));
            aboutUsLink.click();
            Assert.assertTrue(driver.getCurrentUrl().contains("https://www.ixigo.com/"));
            test.log(Status.PASS, "Successfully navigated to About Us page");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Navigation to About Us page failed");
            takeScreenshot("navigate_to_about_us_failed");
            throw e; 
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        extent.flush();
    }

    public void takeScreenshot(String filename) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Extent-Day\\ixigoo\\src\\screenshots\\") + filename + ".png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(destination.getAbsolutePath());
    }
}
