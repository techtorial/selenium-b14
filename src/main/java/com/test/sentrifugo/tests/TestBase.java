package com.test.sentrifugo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

import java.time.Duration;

public class TestBase {

   public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
    }

    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }
}
