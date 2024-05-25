package com.example;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AppTest
{
    @Test
    public void testcase() throws MalformedURLException, InterruptedException
    {
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);

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
           System.out.println("url verified");
        }
        
    }
}