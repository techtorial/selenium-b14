package ActionClass;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;

public class DragAndDrop {

    @Test
    public void validateTheMessageAndColor(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement acceptCookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();
        WebElement circle=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage= BrowserUtils.getText(target);//....Or here.
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(circle,target).perform();
        target=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessageAfterDrop=BrowserUtils.getText(target);//You did great!
        String expectedMessageAfterDrop="You did great!";
        Assert.assertEquals(actualMessageAfterDrop,expectedMessageAfterDrop);
        String orangeBackgroundColor=target.getCssValue("background-color");
        String expectedBackgroundColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(orangeBackgroundColor,expectedBackgroundColor);
    }
    //CLICKANDHOLD METHOD
    @Test
    public void validateBlueBoxDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions=new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        actions.scrollByAmount(200,200);
        WebElement acceptCookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();
        WebElement circle=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target=driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(BrowserUtils.getText(target),"Drag the small circle here ...");
        actions.clickAndHold(circle).moveToElement(target).release().perform();
        target=driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(BrowserUtils.getText(target),"You did great!");
        Assert.assertEquals(target.getCssValue("background-color"),"rgba(63, 81, 181, 1)");
    }

    @Test
    public void validateMessageAndColor(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        Assert.assertEquals(BrowserUtils.getText(dropHere),"Drop here");
        actions.dragAndDrop(dragMe,dropHere).perform();
        dropHere=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getText(dropHere),"Dropped!");
        Assert.assertEquals(dropHere.getCssValue("background-color"),"rgba(70, 130, 180, 1)");
    }

    @Test
    public void validateBoxAndColorClickAndHold(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.id("droppableExample-tab-accept"));
        acceptButton.click();
        WebElement source=driver.findElement(By.id("notAcceptable"));
        WebElement target=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Assert.assertTrue(BrowserUtils.getText(target).equals("Drop here"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().perform();
        target=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getText(target), "Drop here");
    }
    @Test //information for the usage of String and int
    public void test(){
        String[] values={"1","2","11","4","15"};
        int[] values1={1,2,11,4,15};
        Arrays.sort(values);
        Arrays.sort(values1);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(values1));

    }

}
