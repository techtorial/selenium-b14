package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNGPractice {
/*
    TASK:
            1-login successfully-->username--demo password -->demo
        2-validate(ASSERT) title -->Dashboard
         */
    @Test
    public void validateTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        String actualTitle=driver.getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);
        //As a good tester please do at least 1 negative scenario like removing letter
    }

    @Test
    public void validateURl(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demo.opencart.com/admin/index.php?route=common/dashboard&user_token=";
      //  Assert.assertEquals(actualUrl.contains(expectedUrl),true);
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void validateProductCrossButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productButton=driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productButton=driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=1;i<allBoxes.size();i++){
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertTrue(allBoxes.get(i).isEnabled());
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
        //validation -->boxes are displayed, enabled, click selected
    }

    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productButton=driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        WebElement productNameButton=driver.findElement(By.xpath("//a[@class='asc']"));
        productNameButton.click();
        Thread.sleep(1000);
        List<WebElement> allBrands=driver.findElements(By.xpath("//td[@class='text-start']"));//10
        List<String> actualBrands=new ArrayList<>();
        List<String> expectedBrands=new ArrayList<>();
        for(int i=1;i<allBrands.size();i++){
            Thread.sleep(1000);
            actualBrands.add(allBrands.get(i).getText().toLowerCase().trim());
            expectedBrands.add(allBrands.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedBrands);//sorted all brand
        Collections.reverse(expectedBrands);
        System.out.println(actualBrands);
        System.out.println(expectedBrands);
        Assert.assertEquals(actualBrands,expectedBrands);



        /*
        1-Click productName button
        2-Validate the list is descending order

         TIPS:
         1-For comparison I would create two arraylists
           ->actual arraylist
           ->expected arraylist
         2-I would store all of the string inside of these lists with the loop and add method
         3-I would sort the expected one
         4-I would reverse the expected one (Collections.reverse)
         5-I would compare at the end
         */


    }
}
