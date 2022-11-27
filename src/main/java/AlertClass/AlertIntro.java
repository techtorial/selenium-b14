package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        JsAlert.click();
        Alert alert=driver.switchTo().alert();//it will be handling your JS pop-up
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You successfully clicked an alert");
    }

    @Test
    public void alertDismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JSConfirm=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        JSConfirm.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You clicked: Cancel");
        /*
        1-Navigate to the website
        2-Click click for Confirm button
        3-validate the text (I am a JS Confirm)
        4-Click Cancel Button
        5-Validate the message "You clicked:Cancel
         */
    }
    @Test
    public void sendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JSPrompt=driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        JSPrompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Ahmet");
        alert.accept();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You entered: Ahmet");
    }
}
