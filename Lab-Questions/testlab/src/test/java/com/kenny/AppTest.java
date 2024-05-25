package com.kenny;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {
    // @BeforeTest
    // public void beforeMethod()
    // {

    // }

    @Test
    public void testcase1() throws Exception
    {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//windows maximize
        driver.get("https://groww.in/");
        Thread.sleep(5000);
        WebElement calculator =  driver.findElement(By.linkText("Calculators"));
        calculator.click();
        Thread.sleep(5000);
        String checkCalc = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/h1")).getText();
        System.out.println(checkCalc);

        if(checkCalc.contains("Calculators"))
        {
            System.out.println("cal found");
            File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(shot, new File("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\testlab\\src\\screenshots\\testCalc.png"));
        }
        else{
            System.out.println("Not found");
        }

        WebElement homeLoan = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/a[15]"));
        homeLoan.click();
        Thread.sleep(5000);

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\testlab\\src\\Excel\\TestData.xlsx"));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell loanCell = row.getCell(0);
        Cell raCell = row.getCell(1);
        Cell tenCell = row.getCell(2);

        String loan = loanCell.getStringCellValue();
        String rateOfInt = raCell.getStringCellValue();
        String ten = tenCell.getStringCellValue();

        WebElement loanAmount = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input"));
        loanAmount.clear();
        loanAmount.sendKeys(loan);
        WebElement rate = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div/input"));
        rate.clear();
        rate.sendKeys(rateOfInt);
        WebElement tenure = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/input"));
        tenure.clear();
        tenure.sendKeys(ten);

        Thread.sleep(10000);


        String auto = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p")).getText();
        if(auto.contains("Your Amortization Details (Yearly/Monthly)"))
        {
            File verify = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(verify, new File("C:\\Users\\suren\\OneDrive\\Desktop\\Selenium\\Lab-Questions\\testlab\\src\\screenshots\\verify.png"));
        }

        driver.close();//window close
    }
}