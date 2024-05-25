package com.suren;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
    public void navigateToCalculatorPage() throws Exception {
        test = extent.createTest("Navigate to Calculator Page");
        driver.get("https://www.groww.in/");
        WebElement calculatorsLink = driver.findElement(By.linkText("Calculators"));
        calculatorsLink.click();


        Thread.sleep(10000);
        WebElement calculatorsLabel = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/h1"));
        Assert.assertTrue(calculatorsLabel.isDisplayed());
        test.log(Status.PASS, "Successfully navigated to the Calculator page");
        takeScreenshot("calculator_page_shot");
    }

    @Test(priority = 2)
    public void calculateHomeLoanEMI() throws IOException, MalformedURLException, InterruptedException {
        // String filePath = "C:/Users/suren/OneDrive/Documents/TestData.xlsx"; 
        // FileInputStream fis = new FileInputStream(new File(filePath));
        // Workbook workbook = WorkbookFactory.create(fis);
        // Sheet sheet = workbook.getSheetAt(0); 

        // String loanAmount = sheet.getRow(1).getCell(0).getStringCellValue();
        // String rateOfInterest = sheet.getRow(1).getCell(1).getStringCellValue(); 
        // String loanTenure = sheet.getRow(1).getCell(2).getStringCellValue();

        String loanAmount = "2300000";
        String rateOfInterest = "8";
        String loanTenure = "25";

    

        test = extent.createTest("Calculate Home Loan EMI");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
        WebElement homeLoanEMILink = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/a[15]"));
        homeLoanEMILink.click();
        Thread.sleep(10000);
        WebElement loanAmountField = driver.findElement(By.id("LOAN_AMOUNT"));
        loanAmountField.clear();
        loanAmountField.sendKeys(loanAmount);
        WebElement rateOfInterestField = driver.findElement(By.id("RATE_OF_INTEREST"));
        rateOfInterestField.clear();
        rateOfInterestField.sendKeys(rateOfInterest);
        WebElement loanTenureField = driver.findElement(By.id("LOAN_TENURE"));
        loanTenureField.clear();
        loanTenureField.sendKeys(loanTenure);

        Thread.sleep(10000);
        WebElement amortizationDetails = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p"));
        Assert.assertTrue(amortizationDetails.isDisplayed());
        test.log(Status.PASS, "Home Loan EMI calculated successfully");
        takeScreenshot("home_loan_emi_calculated");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        extent.flush();
    }

    public void takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Extent-Day\\groww\\src\\reports\\screenshots\\")  + filename + ".png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(destination.getAbsolutePath());
    }
}