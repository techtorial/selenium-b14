package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class RealInterviewQuestion {

    @Test
    public void validatingTheSDET(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.thespruceeats.com/");
        WebElement video=driver.findElement(By.xpath("//video[@class='jw-video jw-reset']"));
        BrowserUtils.scrollIntoView(driver,video);
        WebElement button=driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-display jw-button-color jw-reset']"));
        button.click();
    }
}
