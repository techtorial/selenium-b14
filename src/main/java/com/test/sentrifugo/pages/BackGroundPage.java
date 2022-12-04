package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BackGroundPage {

    public BackGroundPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@class='sprite addrecord']")
    WebElement addButton;

    @FindBy(id = "s2id_employee")
    WebElement employeeBox;

    @FindBy(xpath = "//span[contains(text(),'Harris, Human Resource')]")
    WebElement harris;

    @FindBy(xpath = "//div[@id='personalDetailsDiv']//span")
    List<WebElement> allInformation;

    @FindBy(id = "checktype-2")
    WebElement creditBox;

    @FindBy(xpath = "//div[.='No agency']")
    WebElement noAgency;

    @FindBy(id = "submitbutton")
    WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'You cannot send')]")
    WebElement topMessage;

    public void validationOfBackGroundCheck(WebDriver driver,String name,String emailId,String contactNumber,
                                            String address,String status,String expectedAgent,String expectedMessage) throws InterruptedException {
        addButton.click();
        Thread.sleep(3000);
        employeeBox.click();
        Thread.sleep(3000);
        harris.click();
        Thread.sleep(3000);
        List<String> expectedValues= Arrays.asList(name,emailId,contactNumber,address,status);
        for(int i =0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedValues.get(i));
        }
        Thread.sleep(3000);
        BrowserUtils.scrollIntoView(driver,saveButton);
        creditBox.click();
        Assert.assertEquals(BrowserUtils.getText(noAgency),expectedAgent);
        Thread.sleep(3000);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(topMessage),expectedMessage);
        Thread.sleep(3000);
    }
}
