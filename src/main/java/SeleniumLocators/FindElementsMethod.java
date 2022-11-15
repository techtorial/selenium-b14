package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/techtorial/Documents/Techtorialhtml.html");
        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement box:allBoxes){
            if(box.isDisplayed()&&box.isEnabled()&&!box.isSelected()){
                Thread.sleep(1000);
                box.click();
            }
        }
    }
}
