package com.example.seleniumassignment;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Scenario3 {
    public static void execute(WebDriver driver) throws InterruptedException {
        driver.get("https://service.northeastern.edu/tech?id=classrooms");
        driver.findElement(By.xpath("//*[@id=\"x77ea03d9972dd1d8beddb4221153afa6\"]/div/div[2]/span/div/div/div[1]/div/div/div/a")).click();
        //driver.get("https://service.northeastern.edu/tech?id=classroom_details&classroom=9ac92fb397291d905a68bd8c1253afd0");
        driver.findElement(By.xpath("//*[@id=\"x51d2fa949721d518beddb4221153af23\"]/div/div[2]/span/table[1]/tbody/tr[1]/td[2]/a")).click();
        String url = driver.findElement(By.xpath("//*[@id=\"x51d2fa949721d518beddb4221153af23\"]/div/div[2]/span/table[1]/tbody/tr[1]/td[2]/a")).getAttribute("href");
        System.out.println(url);
        try {
            URLDownloader.downloadURL(url, "/Users/haotian/Downloads/downloaded.pdf");
            System.out.println("downloaded from url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
