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

public class AlertPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");
        ////h5[contains(text(),'Normal alert')]//..//button
        WebElement previewFirst=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewFirst.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        alert.accept();
        WebElement PreviewSecond=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        PreviewSecond.click();
        WebElement message=driver.findElement(By.xpath("//div[@class='swal-modal']"));
        Assert.assertTrue(BrowserUtils.getText(message).contains("Something went wrong!"));
        WebElement OkButton=driver.findElement(By.xpath("//button[.='OK']"));
        OkButton.click();
        driver.close();
    }
}
