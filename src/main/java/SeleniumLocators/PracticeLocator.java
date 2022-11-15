package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticeLocator {

        /*
1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
2-Fill all the boxes
3-Click privacy link
4-Validate the text(if else) and close the tab
5-CLick privacy button box if it is not selected
4-Click continue button
5-Validate Account is created header (if else)

NOTE:To be able get see account is created for you last run make sure you have a different email
just add ahmet1,ahmet2 like that everytime for validation.
}
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName=driver.findElement(By.cssSelector("#input-firstname"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.cssSelector("#input-lastname"));
        lastName.sendKeys("Baldir");
        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("ahmet156@gmail.com");
        WebElement phoneNumber=driver.findElement(By.id("input-telephone"));
        phoneNumber.sendKeys("315-155-12-12");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("ahmet123");
        WebElement confirmPassword=driver.findElement(By.name("confirm"));
        confirmPassword.sendKeys("ahmet123");
        WebElement privacyLink=driver.findElement(By.linkText("Privacy Policy"));
        privacyLink.click();
        WebElement privacyText=driver.findElement(By.cssSelector(".modal-title"));
        String actualText=privacyText.getText().trim();
        String expectedText="Privacy Policy";
        if(actualText.equals(expectedText)){
            System.out.println("text is correct");
        }else{
            System.out.println("test is wrong");
        }
        WebElement xButton=driver.findElement(By.cssSelector(".close"));
        xButton.click();
        WebElement privacyBox=driver.findElement(By.xpath("//input[@name='agree']"));
        if(!privacyBox.isSelected()){
            privacyBox.click();
        }
        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        WebElement validateHeader=driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader=validateHeader.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Account is created");
        }else{
            System.out.println("Account is not created");
        }
    }

}
