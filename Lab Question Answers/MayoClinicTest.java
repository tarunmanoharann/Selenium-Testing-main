package runner;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;

public class AppTest extends Base {
    WebDriver driver;
    Screenshot ss;
    LoggerHandler logger;
    Reporter rr;

    @Test
    public void testcase() throws Exception
    {
        logger.logInfo("Test started");
        driver = openBrowser();
        Thread.sleep(3000);

        WebElement drop = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/header/div[2]/div/nav/div/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/ul/li[5]/div[1]/div/button"));
        drop.click();

        WebElement opt = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/header/div[2]/div/nav/div/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/ul/li[5]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/a"));
        opt.click();

        Thread.sleep(3000);

        WebElement price = driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[1]/div[1]/label[3]"));
        price.click();

        WebElement desig = driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[1]/div[3]/select"));
        desig.click();

        WebElement desigOpt = driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[1]/div[3]/select/option[8]"));
        desigOpt.click();
        
        WebElement giftOpt = driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[2]/div[1]"));
        giftOpt.click();

        WebElement title=driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[1]/div[1]/select"));
    title.click();

    WebElement tit =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[1]/div[1]/select/option[2]"));
    tit.click();


    
    WebElement fname=driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[1]/div[2]/input"));
    fname.sendKeys("Tester");

    WebElement testerlast =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[1]/div[3]/input"));
    testerlast.sendKeys("TesterLast");
    
    WebElement country=driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[2]/div[1]/select"));
    country.click();

    WebElement India =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[2]/div[1]/select/option[80]"));
    India.click();

    WebElement state =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[2]/div[2]/select"));
    state.click();

    WebElement na =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[2]/div[2]/select/option[2]"));
    na.click();

    
    WebElement add =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[3]/div[1]/input"));
    add.sendKeys("10/10");

    WebElement city =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[3]/div[2]/input"));
    city.sendKeys("cbe");

    WebElement zip =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[3]/div[3]/input"));
    zip.sendKeys("54321");

    WebElement ph_no =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[4]/div[1]/input"));
    ph_no.sendKeys("1234509876");

    WebElement email =driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/fieldset[3]/div[4]/div[2]/input"));
    email.sendKeys("shyam@gmail.com");

    WebElement makemygift=driver.findElement(By.xpath("/html/body/form[2]/div[3]/main/div/div/div[2]/div[1]/div/div/div[1]/div/div/button"));
    makemygift.click();

    Thread.sleep(10000);

    WebElement popup=driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div[1]/h1"));
    
    if(popup.getText().equals("Complete payment"))
    {
      ss.getScreenShot(driver,"payment.png");
    }

    rr.generateExtentReport("mayoclinic-reports");


    }
    
}
