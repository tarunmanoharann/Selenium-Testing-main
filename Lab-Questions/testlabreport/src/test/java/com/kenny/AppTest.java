package com.kenny;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AppTest {
    WebDriver driver;

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    @Test
    public void testcase() throws Exception
    {
        test = extent.createTest("Navigate to the website");
        driver.get("http://dbankdemo.com/bank/login");
        Thread.sleep(10000);
        WebElement email = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input"));
        email.sendKeys("S@gmail.com");
        
        WebElement pwd = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/input"));
        pwd.sendKeys("P@ssword12");
        
        WebElement btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button"));
        btn.click();
        
        WebElement verify = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/h1"));
        Assert.assertTrue(verify.isDisplayed());
        test.log(Status.PASS, "Page displayed sucessfuly");
        

    }

    @AfterTest
    public void finalSet()
    {
        extent.flush();
    }
}