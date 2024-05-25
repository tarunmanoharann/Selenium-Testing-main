package com.suren;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest
{
    @Test
    public void testCase() throws Exception
    {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://groww.in/");
        Thread.sleep(5000);
        WebElement calc = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div[3]/a[2]"));
        calc.click();
        Thread.sleep(10000);
        WebElement checkHead = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/h1"));
        if(checkHead.getText().equals("Calculators"))
        {
            System.out.println("Element found");
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Extent-Day\\testshyam\\src\\check.png"));
        }
        else{
            System.out.println("Element not found");
        }

    }
}