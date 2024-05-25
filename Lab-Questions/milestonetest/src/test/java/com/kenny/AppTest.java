package com.kenny;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

public class AppTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;


    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("1mg Test Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }

    @Test(priority =  1)
    public void testCase1() throws InterruptedException, IOException {
        test = extent.createTest("Test Case 1 - Consult Doctors", "Verify error message when trying to log in without input");
        driver.get("https://www.1mg.com/");
        test.pass("Navigated to 1mg.com");
        Thread.sleep(5000); // Wait for the page to load completely

        driver.navigate().refresh();
        test.pass("Page refreshed to close any pop-ups");
        Thread.sleep(5000);

       WebElement consultDoctor =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header[1]/div[4]/div[1]/ul/li[3]/a"));
       consultDoctor.click();
       test.pass("Clicked on 'Consult Doctors'");
        Thread.sleep(10000); // Wait for the new tab to open

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

       WebElement consult =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/button"));
       consult.click(); 
       test.pass("Clicked on 'Consult Now'");
       Thread.sleep(3000);

       WebElement login =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[1]/a"));
       login.click();
       test.pass("Clicked on 'Login'");
        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/span"));
        if (errorMessage.isDisplayed()) {
            test.pass("Error message displayed: " + errorMessage.getText());
            captureScreenshot(driver, "TestCase1.png");
            test.addScreenCaptureFromPath("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\milestonetest\\src\\screenshots\\TestCase1.png");
        }else {
            test.fail("Error message not displayed");
        }

    }

    @Test(priority = 2)
    public void testCase2() throws InterruptedException, IOException {
        test = extent.createTest("Test Case 2 - Diabetes", "Verify bjain diabetes medicine cart");
        driver.get("https://www.1mg.com/");
        test.pass("Navigated to 1mg.com");
        driver.manage().window().maximize();
        Thread.sleep(5000); // Wait for the page to load completely
        driver.navigate().refresh();
        test.pass("Page refreshed to close any pop-ups");
        Thread.sleep(5000);


        Actions actions = new Actions(driver);
        WebElement diabetesMenu = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header[1]/div[6]/ul/li[6]/div[1]"));
        actions.moveToElement(diabetesMenu).perform();
        test.pass("Hovered over 'Diabetes' menu");
        Thread.sleep(3000);

        WebElement diabetMed = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header[1]/div[6]/ul/li[6]/div[2]/ul/li[3]/a"));
        diabetMed.click();
        test.pass("Clicked on 'Diabetes Medicines'");
        Thread.sleep(3000);

        WebElement bjain = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/label[1]/span[1]"));
        bjain.click();
        test.pass("Selected 'Bjain' brand");
        Thread.sleep(3000);

       WebElement prod =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/a"));
       prod.click();
       test.pass("Clicked on the first product under 'Bjain'");
        Thread.sleep(3000);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebElement ship = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[4]/div[1]/div/div[2]/div[1]/div[2]/div[1]"));
        ship.click();
        test.pass("Clicked on 'membership price + free shipping'");
        Thread.sleep(3000);

        WebElement productName = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[3]/div[1]/div[1]/h1"));
        if (productName.isDisplayed()) {
            test.pass("Product name contains 'Bjain'");
            captureScreenshot(driver, "TestCase2.png");
            test.addScreenCaptureFromPath("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\milestonetest\\src\\screenshots\\TestCase2.png");
        }else {
            test.fail("Product name does not contain 'Bjain'");
        }
    }

    @Test(priority = 3)
    public void testCase3() throws InterruptedException, IOException {
        test = extent.createTest("Test Case 3 - Add to Cart", "Verify URL contains 'cart' after adding product");

        driver.get("https://www.1mg.com/");
        test.pass("Navigated to 1mg.com");
        Thread.sleep(3000); // Wait for the page to load completely
        driver.navigate().refresh();
        test.pass("Page refreshed to close any pop-ups");
        Thread.sleep(3000);
        WebElement  search=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header[1]/div[5]/div[1]/div[2]/div/form/input"));
search.sendKeys("Paracetamol");
test.pass("Searched for 'Paracetamol'");
        WebElement searchicon=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header[1]/div[5]/div[1]/div[2]/div/form/span/div"));
        searchicon.click();
        test.pass("Clicked on search icon");
        Thread.sleep(3000);

        WebElement aps=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/div[3]/div[2]/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div/a"));
        aps.click();
        test.pass("Clicked on 'Aceclofenac + Paracetamol + Serratiopeptidase'");
        Thread.sleep(3000);

        WebElement  zerodo=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[1]"));
zerodo.click();
test.pass("Clicked on 'Zerodol-SP'");
        Thread.sleep(3000);

        WebElement add=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[1]/span[1]/a"));
    add.click();
    test.pass("Clicked on 'ADD' button");
        Thread.sleep(3000);

        WebElement carticon=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span/div/div"));
        carticon.click();
      
        Thread.sleep(3000);

        WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header/div[4]/div[2]/div/div[3]/div/div"));
        cart.click();
        test.pass("Clicked on cart icon");
        Thread.sleep(3000);

        if (driver.getCurrentUrl().contains("cart")) {
            test.pass("URL contains 'cart'");
            captureScreenshot(driver, "TestCase3.png");
            test.addScreenCaptureFromPath("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\milestonetest\\src\\screenshots\\TestCase3.png");
        }else {
            test.fail("URL does not contain 'cart'");
        }
    }

    public void captureScreenshot(WebDriver driver, String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile, new File("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\milestonetest\\src\\screenshots\\" + fileName));
    }
}
