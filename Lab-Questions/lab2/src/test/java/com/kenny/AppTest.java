package com.kenny;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testcase() throws Exception
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.shoppersstop.com/");
        Thread.sleep(10000);

        WebElement profile = driver.findElement(By.xpath("/html/body/main/header/div[1]/div/div[2]/div[2]/ul/li[4]/a"));
        profile.click();

        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getPageSource().length());

        driver.navigate().to("https://www.google.com");
        
        Thread.sleep(5000);

        driver.navigate().back();

        if(driver.getCurrentUrl().equals("https://www.shoppersstop.com/"))
        {
           File verify =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(verify, new File("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\lab2\\src\\screenshots\\verify.png"));
        }

        driver.close();
    }
}