package com.example.seleniumassignment;
import com.example.seleniumassignment.LoginHelper;
import com.example.seleniumassignment.Assets;
import org.openqa.selenium.WebDriver;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        LoginHelper loginhelper = new LoginHelper();
        WebDriver driver = loginhelper.login(Assets.getUsername(), Assets.getPassword());
        Scenario3.execute(driver);
    }
}
