package com.suren;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AppTest{
    public static WebDriver driver;
	public final int IMPLICIT_WAIT_TIME=2000;
	public final int PAGE_LOAD_TIME=5000;

	@Test
    public void TestLocators() throws MalformedURLException, InterruptedException{
        driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.findElement(By.linkText("Laptops")).click();
		Thread.sleep(PAGE_LOAD_TIME);
		driver.findElement(By.linkText("MacBook air")).click();
		Thread.sleep(PAGE_LOAD_TIME);
		driver.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/a")).click();
		Thread.sleep(IMPLICIT_WAIT_TIME);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Cart")).click();
		Thread.sleep(PAGE_LOAD_TIME);
     
    }

	@Test
	 public void loginTest() throws IOException, InterruptedException {
        
       
         driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");

        WebElement loginOption = driver.findElement(By.id("login2"));
        loginOption.click();

        String username = null;
        String  password = null;
        String filePath = "C:/Users/suren/OneDrive/Documents/TestData.xlsx"; 
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0); 
        Row row = sheet.getRow(1); 
        Cell usernameCell = row.getCell(0);
        Cell passwordCell = row.getCell(1);

        username = usernameCell.getStringCellValue();
        password = passwordCell.getStringCellValue();

        
        System.out.println(username);
        System.out.println(password);
        WebElement usernameInput = driver.findElement(By.id("loginusername"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("loginpassword"));
        passwordInput.sendKeys(password);


        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        Thread.sleep(6000);
        WebElement welcomeMessage = driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[7]/a"));
        String welcomeText = welcomeMessage.getText();
        if (welcomeText.contains("Welcome " + username)) {
            System.out.println("Login Successful. Welcome message found: " + welcomeText);
        } else {
            System.out.println("Login Failed. Welcome message not found.");
        }

    
        driver.quit();
    }


// @Test(priority = 3)
// public void testCase3() throws InterruptedException, IOException {
// driver.get("https://www.1mg.com/");
// Thread.sleep(3000); 

// WebElement  search=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header[1]/div[5]/div[1]/div[2]/div/form/input"));
// search.sendKeys("Paracetamol");

// WebElement findclick=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header[1]/div[5]/div[1]/div[2]/div/form/span/div"));
// findclick.click();
// Thread.sleep(3000);

// WebElement words=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/div[3]/div[2]/div[1]/div/div[1]/div[3]/div/div/div[2]/div/div[2]/div/div/div/a/div"));
// words.click();
// Thread.sleep(3000);

// WebElement zeroword =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[1]/span[1]/a"));
// zeroword.click();
// Thread.sleep(3000);

// WebElement add =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span/div/div"));
// add.click();
// Thread.sleep(3000);

// WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/header/div[4]/div[2]/div/div[3]/div/div"));
// cart.click();
// Thread.sleep(3000);

// if (driver.getCurrentUrl().contains("cart")) {
// captureScreenshot(driver, "TestCase3.png");
// }
// }

// public void captureScreenshot(WebDriver driver, String fileName) throws IOException {
// File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
// FileHandler.copy(srcFile, new File("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\milestonetest\\src\\screenshots\\" + fileName));
// }


}




