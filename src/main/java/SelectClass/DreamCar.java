package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class DreamCar {

        /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */
    @Test
    public void validateHeaders() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");

        WebElement newUsed=driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed,"New","text");

        WebElement makes=driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makes,"lexus","value");

        WebElement models=driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");

        WebElement price=driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceOption=new Select(price);
        WebElement firstOption=priceOption.getFirstSelectedOption();
        Assert.assertEquals(BrowserUtils.getText(firstOption),"No max price");

        WebElement distance=driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"3","index");

        WebElement zipCode=driver.findElement(By.id("make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton=driver.findElement(By.xpath("//button[contains(text(),'Search') and @data-searchtype='make']"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement header=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header),"New Lexus RX 350 for sale");

        WebElement sorting=driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(sorting,"Lowest price","text");

        List<WebElement> allTitles=driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement title:allTitles){
            System.out.println(BrowserUtils.getText(title));
            Assert.assertTrue(title.getText().contains("Lexus RX 350"));
            Assert.assertEquals(title.getText().trim().contains("Lexus RX 350"),true);
        }
    }

    //HOMEWORK:
    /*
    1-Choose any car you want to buy
    2-Whenever you choose the lowest price from sorting
    3-VALIDATE the prices are from lowest to highest(remember 2 list)
    4-AFter that choose the highest price from sorting
    5-VALIDATE the prices are from highest to lowest(remember 2 list)
    NOTE:I would think about replacing $ and , with nothing or , with . (if you want to use double)
    NOTE:I would use lists for comparison
    NOTE:Good luck
     */
}
