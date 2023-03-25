package com.example.seleniumassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper {
    public WebDriver login(String username, String password) throws InterruptedException {
//setting the driver executable
        System.setProperty("webdriver.chrome.driver", "/Users/haotian/Desktop/INFO6255Selenium/chromedriver_mac_arm64 /chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver =  new ChromeDriver(options);
        driver.get("https://me.northeastern.edu/");
        driver.findElement(By.className("idpDescription")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']"))).sendKeys(username);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']"))).sendKeys(password);
        driver.findElement(By.name("_eventId_proceed")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //manually sleep the app for 30s for 2FA Auth
        Thread.sleep(30000);
        driver.get("https://northeastern.sharepoint.com/sites/studenthub");
        return driver;
    }

}