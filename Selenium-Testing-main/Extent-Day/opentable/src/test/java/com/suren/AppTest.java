package com.suren;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod
    public void setUp() {
        // Set up ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testOpenTable() {
        test = extent.createTest("OpenTable Test");

        try {
            driver.get("https://www.opentable.com");
            Thread.sleep(10000);

            WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='Location, Restaurant, or Cuisine']"));
            inputBox.click();
            inputBox.sendKeys("Bangalore");
            inputBox.sendKeys(Keys.ENTER);

            Thread.sleep(10000);

            WebElement firstHotel = driver.findElement(By.xpath("//*[@id='mainContent']/div/div/div[2]/div/div[1]/a/img"));
            firstHotel.click();
            Thread.sleep(2000); 

            String parentWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            takeScreenshot("hotel_details");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 500)");

            Thread.sleep(10000);
            

            Thread.sleep(10000);
            WebElement partySizeDropdown = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[1]/div/select"));
            Thread.sleep(2000);
            partySizeDropdown.click();
            partySizeDropdown.sendKeys(Keys.ARROW_DOWN);
            partySizeDropdown.sendKeys(Keys.ENTER);
            Thread.sleep(10000);
            
            WebElement datePicker = driver.findElement(By.xpath("//*[@id='restProfileSideBarDtpDayPicker-label']"));
            datePicker.click();
            WebElement dateElement = driver.findElement(By.xpath("//*[@id='restProfileSideBarDtpDayPicker-wrapper']/div/div/div/table/tbody/tr[6]/td[7]/button"));
            dateElement.click();

            WebElement timePicker = driver.findElement(By.xpath("//*[@id='restProfileSideBartimePickerDtpPicker']"));
            timePicker.click();
            timePicker.sendKeys(Keys.ARROW_UP);
            timePicker.sendKeys(Keys.ENTER);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            
            WebElement findTimeButton = driver.findElement(By.xpath("//*[@id='mainContent']/div/div[2]/div[2]/div/article/div/div[5]/button"));
            findTimeButton.click();
        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed: " + e.getMessage());
            takeScreenshot("test_failed");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.flush();
    }

    public void takeScreenshot(String filename) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Extent-Day\\opentable\\src\\screenshots") + filename + ".png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(destination.getAbsolutePath());
    }
}


