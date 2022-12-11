package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.time.Duration;

public class LoginTest extends TestBase{

    @Test(priority = 2)
    public void validatePositiveLogin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("sentrifugousername"),ConfigReader.readProperty("sentrifugopassword"));
        Assert.assertEquals(loginPage.title(driver),"Sentrifugo - Open Source HRMS");
        Assert.assertEquals(driver.getTitle().trim(),"Sentrifugo - Open Source HRMS");
    }
    @Test(priority = 1)
    public void validateNegativeLogin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("","");
        Assert.assertEquals(loginPage.userNameErrorMessage(),"Please enter username or emaill.");
        Assert.assertEquals(loginPage.passwordErrorMessage(),"Please enter password.");
        Assert.assertEquals(loginPage.colorOfUsernameErrorMessage(),"rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.colorOfPasswordErrorMessage(),"rgba(255, 0, 0, 1)");
    }















}
