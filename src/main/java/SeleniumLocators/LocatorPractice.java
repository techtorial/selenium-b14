package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {

    /*
    1-Navigate to the internet heroku-app https://the-internet.herokuapp.com/
    2-Click the Horizontal Slider
    3-Print out the Header (Horizontal Slider)
    4-Print out the paragraph(kind of header)
    5-Click Elemental Selenium
    6-Driver.quit
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement horizontalLine=driver.findElement(By.linkText("Horizontal Slider"));
        horizontalLine.click();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(header.getText().trim());
        WebElement subheader=driver.findElement(By.className("subheader"));
        System.out.println(subheader.getText().trim());
        WebElement elementalSelenium=driver.findElement(By.partialLinkText("Elemental"));
        elementalSelenium.click();
        driver.quit();
    }



}
