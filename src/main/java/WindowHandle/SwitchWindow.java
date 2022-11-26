package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        String mainPageId=driver.getWindowHandle(); //12345
        System.out.println(mainPageId);
        Set<String> allPagesId=driver.getWindowHandles();//12345,23451
        System.out.println(allPagesId);

        for(String id:allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement header=driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(header),"New Window");
    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2=driver.findElement(By.id("newTabBtn"));
        BrowserUtils.scrollIntoView(driver,button2);
        button2.click();
        String mainIdPage=driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();
        for(String id:allPagesId){ //12345 // 123456, //154354
            if(!id.equals(mainIdPage)){
                driver.switchTo().window(id);
            }
        }
        Assert.assertEquals(driver.getTitle(),"AlertsDemo - H Y R Tutorials");
       WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
       Assert.assertEquals(BrowserUtils.getText(header),"AlertsDemo");
       WebElement alertBox=driver.findElement(By.id("alertBox"));
       alertBox.click();
       driver.quit();
            /*
TASK:
  1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
  2-Click Open New Tab under Button2
  3-Get the title of the newTab and validate"
  4-Get the header of the newTab and validate "AlertsDemo"
  5-Click click me button
  6-Quit the tabs
 */
    }

    @Test
    public void task(){
        /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4=driver.findElement(By.id("newTabsBtn"));
        BrowserUtils.scrollIntoView(driver,button4);
        button4.click();
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("Baldir");
        WebElement gender=driver.findElement(By.xpath("//input[@id='malerb']"));
        gender.click();
        WebElement language=driver.findElement(By.id("englishchbx"));
        BrowserUtils.scrollIntoView(driver,language);
        language.click();
        WebElement email=driver.findElement(By.cssSelector("#email"));
        email.sendKeys("ahmet@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("12345");
        WebElement registerBtn=driver.findElement(By.id("registerbtn"));
        registerBtn.click();
        WebElement message=driver.findElement(By.cssSelector("#msg"));
        Assert.assertEquals(BrowserUtils.getText(message),"Registration is Successful");
        BrowserUtils.switchByTitle(driver,"Window Handles Practice");
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Window Handles Practice')]"));
        Assert.assertEquals(BrowserUtils.getText(header),"Window Handles Practice");
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMe=driver.findElement(By.id("promptBox"));
        clickMe.click();
        driver.quit();
    }
}
