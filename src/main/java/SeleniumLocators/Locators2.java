package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/techtorial/Documents/Techtorialhtml.html");

        //LOCATOR:LinkText
        WebElement java=driver.findElement(By.linkText("Java"));
        java.click();
        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText().trim());

        //1-Go back to the main page
        //2-Click Selenium and printout the header
        //3-Go back to the main page
        //4-Click Cucumber and printout the header
        //5-Go back to the main page
        //6-Click TestNG and printout the header
        //7-Go back to the main page
        //8-Close the driver
        driver.navigate().back();//main
        Thread.sleep(2000);
        WebElement selenium=driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().trim());
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement cucumberHeader=driver.findElement(By.tagName("h1"));
        System.out.println(cucumberHeader.getText().trim());
        driver.navigate().back();
       // driver.close();
        //LOCATOR: PartialLinkText

        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());

    }
}
