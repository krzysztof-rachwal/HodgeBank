package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {
    @Test
    public void ChromeTest() throws InterruptedException, MalformedURLException {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //DesiredCapabilities capability = DesiredCapabilities.chrome();
        //WebDriver driver = new RemoteWebDriver(new URL("http://10.72.98.146:4444/wd/hub"), capability);
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
        driver.findElement(By.id("un")).sendKeys("RachwalK@cardiff.ac.uk");
        Thread.sleep(1000);
        driver.findElement(By.id("pw")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.id("sub")).click();
        driver.get("http://localhost:8080/CreateEventPage");
        //Test case
        String at = driver.getTitle();
        Thread.sleep(1000);
        driver.findElement(By.id("eventTitle")).sendKeys("Selenium Test");
        Thread.sleep(1000);
        driver.findElement(By.id("eventDesc")).sendKeys("Selenium Test");
        Thread.sleep(1000);
        driver.findElement(By.id("location")).sendKeys("Selenium Test");
        Thread.sleep(1000);
        driver.findElement(By.id("eventTime")).sendKeys("1200");
        Thread.sleep(1000);
        driver.findElement(By.id("eventDate")).sendKeys("12042021");
        Thread.sleep(5000);
        //driver.findElement(By.id("tokenfield-2")).sendKeys("RachwalK@cardiff.ac.uk");
        //driver.findElement(By.id("tokenfied-2")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("dietaryReqFalse")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("TeamBasedFalse")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("submitbutton")).click();

        Thread.sleep(4000);
        driver.get("http://localhost:8080/logout");
        //test case
        String et = "";//expected title
        Thread.sleep(2000);
        driver.close();
        if (et.equalsIgnoreCase(at)) {
            System.out.println("Test successful!");
        } else {
            System.out.println("Test failed!");
        }
    }
}


