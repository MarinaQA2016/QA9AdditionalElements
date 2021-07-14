package com.company.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests {
    WebDriver driver;
    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Marina/TelRan/QA%20Courses/Selenium/AlertsDemo.html");
        Thread.sleep(3000);
    }

    @Test
    public void simpleAlert() throws InterruptedException {
        //--- press 'Simple Alert' button
        driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple alert text: " + alert.getText());
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void confirmBoxTest() throws InterruptedException {
        //--- press 'Confirm Box' button
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple alert text: " + alert.getText());
        // --- Accept alert ---
        alert.accept();
        Thread.sleep(3000);
        //--- press 'Confirm Box' button
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        // --- press cancel button on confirm box ----
        alert.dismiss();
        Thread.sleep(3000);

    }

    @Test
    public void promptTest() throws InterruptedException {
        //--- press 'Prompt Box' button
        driver.findElement(By.xpath("//button[contains(text(),'Prompt box')]")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Prompt box text: " + alert.getText());
        // --- Accept prompt ---
        alert.accept();
        Thread.sleep(3000);
        //--- press 'Prompt Box' button
        driver.findElement(By.xpath("//button[contains(text(),'Prompt box')]")).click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        // --- press cancel button for prompt ----
        alert.dismiss();
        Thread.sleep(3000);
        //--- press 'Prompt Box' button
        driver.findElement(By.xpath("//button[contains(text(),'Prompt box')]")).click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        // --- sent text to prompt---
        alert.sendKeys("Ivan Ivanov");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
