package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/techtorial/Downloads/usa.png");
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.submit(); //submit works for form and type --> submit or button
        WebElement header=driver.findElement(By.xpath("//h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(BrowserUtils.getText(header),"File Uploadsd!");
        WebElement attachment=driver.findElement(By.id("uploaded-files"));
        softAssert.assertEquals(BrowserUtils.getText(attachment),"usa.png");
        System.out.println("I validated usa png");

    }

    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("/Users/techtorial/Downloads/Techtorial.pdf");
        WebElement box=driver.findElement(By.cssSelector("#terms"));
        box.click();
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        WebElement message=driver.findElement(By.xpath("//h3//center"));
        Assert.assertEquals(BrowserUtils.getText(message),"1 file\n" +
                "has been successfully uploaded.");
    }



}
