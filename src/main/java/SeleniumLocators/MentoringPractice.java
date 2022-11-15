package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MentoringPractice {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/login");
        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='list-group-item']"));
        for(WebElement element: elements){
            if (!element.isDisplayed()){
                throw new RuntimeException("element is not displayed: "+element.getText());
            }
        }


    }

}
