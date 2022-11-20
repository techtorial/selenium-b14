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

public class SelectBasics {

    //SELECT Class is all about drop down.
    //Drop down must have Select Tag name.

    @Test
    public void practiceSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown=driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement dropDownBox=driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select dropDwn=new Select(dropDownBox);
        List<WebElement> allTheOptions=dropDwn.getOptions();

        for(WebElement option:allTheOptions){
            System.out.println(option.getText().trim());
        }

        WebElement firstSelected=dropDwn.getFirstSelectedOption();
        Assert.assertEquals(firstSelected.getText().trim(),"Please select an option");
        //It chooses the option by VISIBLE TEXT
        dropDwn.selectByVisibleText("Option 2");
        //it chooses the option by VALUE attribute
        Thread.sleep(3000);
        dropDwn.selectByValue("1");
        Thread.sleep(3000);
        dropDwn.selectByIndex(2);
    }

    @Test
    public void selectMultiMethods(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/techtorial/Documents/Techtorialhtml.html");
        WebElement countries=driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(countries,"Two","text");
        BrowserUtils.selectBy(countries,"3","value");
        BrowserUtils.selectBy(countries,"3","index");
        Select country=new Select(countries);
        country.deselectByValue("3");
        country.deselectAll();
    }
}
