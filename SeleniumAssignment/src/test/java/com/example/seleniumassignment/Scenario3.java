package com.example.seleniumassignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Scenario3 {
    public static void execute(WebDriver driver) throws InterruptedException {
        driver.get("https://service.northeastern.edu/tech?id=classrooms");
        System.out.println("opened classroom website url");
        driver.get("https://service.northeastern.edu/tech?id=classroom_details&classroom=9ac92fb397291d905a68bd8c1253afd0");
        System.out.println("opened specific classroom url");
        driver.findElement(By.xpath("//*[@id=\"x51d2fa949721d518beddb4221153af23\"]/div/div[2]/span/table[1]/tbody/tr[1]/td[2]/a")).click();
        String url = driver.getCurrentUrl();
        try {
            URLDownloader.downloadUsingNIO(url, "/Users/haotian/Downloads/downloaded.pdf");
            System.out.println("downloaded from url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
