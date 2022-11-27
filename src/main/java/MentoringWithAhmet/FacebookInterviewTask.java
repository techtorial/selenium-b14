package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FacebookInterviewTask {

    /*
    1-Navigate to https://www.facebook.com/
    2-Click Create Account Button
    3-Fill all the box
    4-Choose Custom Gender
    5-Choose any pronoun you want from option
    6-Click sign up button
    7-In general facebook has a protection to automate create account
    so once you click if it is not giving you any message you are good(you can quit )
    If there is a message then validate it after clicking sign up button

     PURPOSE:1-This task can come during the interview
             2-Dealing with Dynamic element(changing every run)
             3-Practicing the Select Class (common)
     */
    @Test
    public void validationForCreatingAccount(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
        WebElement createButton=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createButton.click();
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Baldir");
        WebElement email=driver.findElement(By.name("reg_email__"));
        email.sendKeys("ahmetBaldir@gmail.com");
        WebElement reEmail=driver.findElement(By.name("reg_email_confirmation__"));
        reEmail.sendKeys("ahmetBaldir@gmail.com");
        WebElement password=driver.findElement(By.id("password_step_input"));
        password.sendKeys("123456");
        WebElement year=driver.findElement(By.id("year"));
        BrowserUtils.selectBy(year,"1991","text");
        //label[.='Custom']//..//input first way of finding custom button
        WebElement customButton=driver.findElement(By.xpath("//label[.='Custom']//following-sibling::input"));
        customButton.click();
        WebElement pronoun=driver.findElement(By.name("preferred_pronoun"));
        BrowserUtils.selectBy(pronoun,"6","value");
        WebElement submit=driver.findElement(By.name("websubmit"));
        submit.click();


    }



    /* 1/2
    1-Navigate to the https://demoqa.com/browser-windows
    2-Click New Tab and validate the message from new window which is "This is a sample page"
    3-Go to the main page and Click Frames from the list(on the left)
    4-Validate This is a sample page from the box
    5-Click Nested Frame from the list(on the left)
    6-Validate Child iframe from the box

        PURPOSE:1-Practicing the GetWindowHandles
                2-Practicing Frames and Nested Frames
     */

    /*

     */
}
