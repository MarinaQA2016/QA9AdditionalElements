package com.company.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsHandling {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        Thread.sleep(10000);
    }
    @Test
    public void windowsHandlingTest() throws InterruptedException {
        //---- print first window handle (code) ---
        String firstWindowHandle = driver.getWindowHandle();
        System.out.println("First window (active) handle: " + firstWindowHandle);
        // ---- Open second window by 'Try it Yourself' button ---
        driver.findElement(By.xpath("//*[contains(text(),'Try it Yourself')]")).click();
        Thread.sleep(5000);
        System.out.println("Active window handle: " + driver.getWindowHandle());
        // ---- Try to print name of the 'Run' button from the second window -----
        /*System.out.println("Run button name: " + driver
                .findElement(By.xpath("//button[contains(text(),'Run »')]")).getText());*/
        // ---- Try to print header from the first window -----
        System.out.println("Header text: " + driver
                .findElement(By.tagName("h1")).getText());
        String secondWindowHandle = "";
        for(String handle: driver.getWindowHandles()){
            System.out.println("Handle: " + handle);
            if (!handle.equals(firstWindowHandle)) secondWindowHandle = handle;
        }
        driver.switchTo().window(secondWindowHandle);
        System.out.println("Active window handle: " + driver.getWindowHandle());

        // ---- Try to print name of the 'Run' button from the second window -----
        System.out.println("Run button name: " + driver
                .findElement(By.xpath("//button[contains(text(),'Run »')]")).getText());
        // ---- Try to print header from the first window -----
        /*System.out.println("Header text: " + driver
                .findElement(By.tagName("h1")).getText());*/

        //------- Window closing ----
        driver.close();
        Thread.sleep(3000);
        //System.out.println("Active window hadle: " + driver.getWindowHandle());
        driver.switchTo().window(firstWindowHandle);
        System.out.println("Active window hadle: " + driver.getWindowHandle());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
