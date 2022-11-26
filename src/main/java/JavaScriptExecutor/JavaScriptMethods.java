package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {

        /*
        NOTE:JavaScript is really efficient once your normal selenium methods are not working as expected
        NOTE2:JavaScript is a different language so it is not recommended to use Java and JavaScript all the time.That's why
        JavaScript methods should be your last option to use.
         -->For example;You are trying to click the element somehow webelement.click is not working
            then you should try Actions.click it is also not working
            THEN USE JAVASCRIPT CLICK METHOD.
         */


    @Test
    public void getTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        System.out.println("Get the title with driver " + driver.getTitle());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println("Get the title with JS " + title);
    }

    @Test
    public void clickJS() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement onlineCourse=driver.findElement(By.xpath("//a[.='Online Course']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",onlineCourse);
        String actualTitle = js.executeScript("return document.title").toString();
        String expectedTitle="Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRight=driver.findElement(By.xpath("//p[contains(text(),'© Copyrights 2022')]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyRight);
        Thread.sleep(3000);
        WebElement onlineCourse=driver.findElement(By.xpath("//a[.='Online Course']"));
        js.executeScript("arguments[0].scrollIntoView(true)",onlineCourse);
    }

        /*
        1-Navigate to the website
        2-ScrollDown to the Browse Course JS
        3-Click the Browse Course with JS
        4-Validate the title JS
        5-Scroll Down to the INFORMATION BOTTOM PAGE JS
        6-Scroll Up to the Student Login Button JS -->Parent-child
         */

    @Test
    public void task1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browser=driver.findElement(By.linkText("Browse Course"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",browser);
        js.executeScript("arguments[0].click()",browser);
        String actualTitle=js.executeScript("return document.title").toString();
        String expectedTitle="Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement information=driver.findElement(By.xpath("//h2[.='information']"));
        js.executeScript("arguments[0].scrollIntoView(true)",information);
        WebElement studentLogin=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        js.executeScript("arguments[0].scrollIntoView(true)",studentLogin);
    }

    @Test
    public void shortCuttest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browser=driver.findElement(By.linkText("Browse Course"));
       // js.executeScript("arguments[0].scrollIntoView(true)",browser);
        BrowserUtils.scrollIntoView(driver,browser);
        BrowserUtils.clickWithJS(driver,browser);
      //  js.executeScript("arguments[0].click()",browser);
        String actualTitle=BrowserUtils.getTitleWithJS(driver);
     //   String actualTitle=js.executeScript("return document.title").toString();
        String expectedTitle="Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement information=driver.findElement(By.xpath("//h2[.='information']"));
        BrowserUtils.scrollIntoView(driver,information);
      //  js.executeScript("arguments[0].scrollIntoView(true)",information);
        WebElement studentLogin=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        BrowserUtils.scrollIntoView(driver,studentLogin);
     //   js.executeScript("arguments[0].scrollIntoView(true)",studentLogin);
    }

    @Test
    public void validatingTheSDET(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browser=driver.findElement(By.linkText("Browse Course"));
        BrowserUtils.scrollIntoView(driver,browser);
        BrowserUtils.clickWithJS(driver,browser);
        WebElement getStarted=driver.findElement(By.xpath("//h4[.='SDET Course']//..//a[.='Get Started']"));
        BrowserUtils.clickWithJS(driver,getStarted);
        String actualTitle=BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply To Techtorial - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
