package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class TechlistAutomation {

    @Test
    public void validateFunctionalityOfForms(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir");
        WebElement genderButton=driver.findElement(By.xpath("//input[@id='sex-0']"));
        genderButton.click();
        WebElement experience=driver.findElement(By.xpath("//input[@id='exp-0']"));
        experience.click();
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.sendKeys("08/13/2022");
        WebElement profession=driver.findElement(By.xpath("//input[@id='profession-1']"));
        profession.click();
        WebElement automation=driver.findElement(By.xpath("//input[@id='tool-0']"));
        automation.click();
        WebElement automationWebDriver=driver.findElement(By.xpath("//input[@id='tool-2']"));
        automationWebDriver.click();
        WebElement continent=driver.findElement(By.xpath("//select[@id='continents']"));
        BrowserUtils.selectBy(continent,"North America","text");
        WebElement commons=driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        BrowserUtils.selectBy(commons,"0","index");
        BrowserUtils.selectBy(commons,"Navigation Commands","text");
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
        //Real Job:There will be a message like you successfully registered



    }
}
