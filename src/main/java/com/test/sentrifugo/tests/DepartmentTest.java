package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.DepartmentPage;
import com.test.sentrifugo.pages.LoginPage;
import com.test.sentrifugo.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DepartmentTest extends TestBase {

    @Test
    public void valitadeMessageForEmployeeCreation() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickDepartment();
        DepartmentPage departmentPage=new DepartmentPage(driver);
        departmentPage.validateMessageOfCreationEmployee(driver,"IT","200","Department added successfully.");
        departmentPage.validateInformationFromTable("Information Technology","IT","01/05/2001","Thomas E",
                "America/New_York [EDT]","Orange Blossom");
    }
}
