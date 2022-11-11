package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro {
    public static void main(String[] args) {
        //ID LOCATOR
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/techtorialacademy/Desktop/Techtorialhtml.html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());
        String actualHeader=header.getText().trim();
        String expectedHeader="Techtorial Academy";//requirement
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Your header is passed");
        }else{
            System.out.println("Your header is failed");
        }
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //LOCATOR : NAME

        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Baldir");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("314 714-838-");

        //LOCATOR: CLASS

         WebElement checkboxes=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxes.getText());

        WebElement javaBox=driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed()){
            javaBox.click();
        }
        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        System.out.println(seleniumBox.isDisplayed());//true
        System.out.println(seleniumBox.isSelected());//true
        seleniumBox.click();
        System.out.println(seleniumBox.isSelected());//false

    }
}
