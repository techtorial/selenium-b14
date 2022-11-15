package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YahooRealInterviewQuestion {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.yahoo.com/");
        WebElement news=driver.findElement(By.xpath("//a[contains(text(),' News  ')]"));
        news.click();
        List<WebElement> allHeaders=driver.findElements(By.xpath("//h3"));
        List<WebElement> allHeaders2=driver.findElements(By.xpath("//h2"));
        for(WebElement header:allHeaders){
            System.out.println(header.getText().trim());
        }
        for(WebElement header2:allHeaders2){
            System.out.println(header2.getText().trim());
        }
    }
}
